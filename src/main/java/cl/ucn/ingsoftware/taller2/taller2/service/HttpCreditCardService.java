package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.authenticate.Credentials;
import cl.ucn.ingsoftware.taller2.taller2.http.HttpWrapperBuilder;
import cl.ucn.ingsoftware.taller2.taller2.model.CreditCard;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

public class HttpCreditCardService implements CreditCardService {

    private static final Map<String, Boolean> CREDIT_CARD_VALIDATE = new HashMap<>();

    private static final String BASE_URL = "https://idonosob.pythonanywhere.com/";
    private final HttpClient httpClient;
    private final Gson gson;

    private String token = null;

    public HttpCreditCardService(Gson gson) {
        httpClient = HttpClient.newHttpClient();
        this.gson = gson;

        CREDIT_CARD_VALIDATE.put("Tarjeta válida", Boolean.TRUE);
        CREDIT_CARD_VALIDATE.put("Tarjeta inválida", Boolean.FALSE);
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

        if (isAuthenticated()) {
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

        if (isAuthenticated()) {
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
        return token == null;
    }

    @Override
    public void pay(CreditCard creditCard, String description, int amount) {

    }

}
