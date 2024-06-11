package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.adapter.CredentialsAdapter;
import cl.ucn.ingsoftware.taller2.taller2.adapter.CreditCardAdapter;
import cl.ucn.ingsoftware.taller2.taller2.adapter.PaymentAdapter;
import cl.ucn.ingsoftware.taller2.taller2.adapter.TokenAdapter;
import cl.ucn.ingsoftware.taller2.taller2.authenticate.Credentials;
import cl.ucn.ingsoftware.taller2.taller2.http.HttpWrapperBuilder;
import cl.ucn.ingsoftware.taller2.taller2.model.CreditCard;
import cl.ucn.ingsoftware.taller2.taller2.model.ObjectToken;
import cl.ucn.ingsoftware.taller2.taller2.model.Payment;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

public class HttpCreditCardService implements CreditCardService {

    private static CreditCardService HTTP_CREDIT_CARD_SERVICE = new HttpCreditCardService();

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(ObjectToken.class, new TokenAdapter())
            .registerTypeAdapter(Credentials.class, new CredentialsAdapter())
            .registerTypeAdapter(CreditCard.class, new CreditCardAdapter())
            .registerTypeAdapter(Payment.class, new PaymentAdapter(new CreditCardAdapter()))
            .create();

    private final Map<String, Boolean> CREDIT_CARD_VALIDATE;
    private final Map<String, Boolean> UPDATE_MONEY;

    private static final String BASE_URL = "https://idonosob.pythonanywhere.com/";
    private final HttpClient httpClient;

    private String token = null;

    private HttpCreditCardService() {
        httpClient = HttpClient.newHttpClient();

        CREDIT_CARD_VALIDATE = new HashMap<>();
        UPDATE_MONEY = new HashMap<>();

        CREDIT_CARD_VALIDATE.put("Tarjeta válida", Boolean.TRUE);
        CREDIT_CARD_VALIDATE.put("Tarjeta inválida", Boolean.FALSE);

        UPDATE_MONEY.put("Cargo realizado exitosamente", Boolean.TRUE);
        UPDATE_MONEY.put("Tarjeta inválida", Boolean.FALSE);

    }

    @Override
    public void authenticate(Credentials credentials) throws IOException, InterruptedException {
        JsonObject jsonObject = new HttpWrapperBuilder<JsonObject>(
                JsonObject.class,
                httpClient,
                gson
        ).url(BASE_URL + "login")
                .applicationJson()
                .body(credentials)
                .post()
                .build();

        token = jsonObject.get("access_token").getAsString();
    }

    @Override
    public boolean validate(CreditCard creditCard) throws IOException, InterruptedException {

        if (!isAuthenticated()) {
            return false;
        }

        JsonObject jsonObject = new HttpWrapperBuilder<JsonObject>(
                JsonObject.class,
                httpClient,
                gson
        ).url(BASE_URL + "validar_tarjeta")
                .authenticationBearerToken(token)
                .applicationJson()
                .body(creditCard)
                .post()
                .build();

        String message = jsonObject.get("msg").getAsString();
        return CREDIT_CARD_VALIDATE.get(message);
    }

    @Override
    public double getBalance(CreditCard creditCard) throws IOException, InterruptedException {

        if (!isAuthenticated()) {
            return -1;
        }

        JsonObject jsonObject = new HttpWrapperBuilder<JsonObject>(
                JsonObject.class,
                httpClient,
                gson
        ).url(BASE_URL + "obtener_saldo")
                .authenticationBearerToken(token)
                .applicationJson()
                .body(creditCard)
                .post()
                .build();

        return jsonObject.get("saldo").getAsDouble();
    }

    @Override
    public boolean isAuthenticated() {
        return token != null;
    }

    @Override
    public boolean pay(CreditCard creditCard, String description, int amount) throws IOException, InterruptedException {
        Payment payment = new Payment(creditCard, description, amount);

        if (!isAuthenticated()) {
            return false;
        }

        JsonObject object = new HttpWrapperBuilder<>(JsonObject.class,
                httpClient,
                gson).url(BASE_URL + "realizar_cargo")
                .body(payment)
                .post()
                .applicationJson()
                .authenticationBearerToken(token)
                .build();

        String message = object.get("msg").getAsString();
        return UPDATE_MONEY.get(message);
    }

    public static CreditCardService getInstance() {
        if (HTTP_CREDIT_CARD_SERVICE == null) {
            HTTP_CREDIT_CARD_SERVICE = new HttpCreditCardService();
        }

        return HTTP_CREDIT_CARD_SERVICE;
    }

}
