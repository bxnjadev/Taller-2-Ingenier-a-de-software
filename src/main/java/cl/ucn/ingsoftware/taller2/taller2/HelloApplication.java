package cl.ucn.ingsoftware.taller2.taller2;

import cl.ucn.ingsoftware.taller2.taller2.authenticate.Credentials;
import cl.ucn.ingsoftware.taller2.taller2.gson.adapter.CredentialsAdapter;
import cl.ucn.ingsoftware.taller2.taller2.gson.adapter.CreditCardAdapter;
import cl.ucn.ingsoftware.taller2.taller2.gson.adapter.PaymentAdapter;
import cl.ucn.ingsoftware.taller2.taller2.gson.adapter.TokenAdapter;
import cl.ucn.ingsoftware.taller2.taller2.http.HttpWrapperBuilder;
import cl.ucn.ingsoftware.taller2.taller2.loader.Loader;
import cl.ucn.ingsoftware.taller2.taller2.loader.UserLoader;
import cl.ucn.ingsoftware.taller2.taller2.model.CreditCard;
import cl.ucn.ingsoftware.taller2.taller2.model.ObjectToken;
import cl.ucn.ingsoftware.taller2.taller2.model.Payment;
import cl.ucn.ingsoftware.taller2.taller2.service.CreditCardService;
import cl.ucn.ingsoftware.taller2.taller2.service.HttpCreditCardService;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.http.HttpClient;
import java.time.Year;

public class HelloApplication extends Application {

    private static final String CODIGO = "567";
    private static final String MES = "10";
    private static final String ANIO = "2027";
    private static final String NUMERO = "4386297350841657";

    private static final String USERNAME = "bmiranda11";
    private static final String PASSWORD = "678234";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        String value = "09788417537401";

        System.out.println(Long.parseLong(value));

        HttpClient httpClient = HttpClient.newHttpClient();

        Credentials userCredentials =
                new Credentials(USERNAME, PASSWORD);

        CreditCard creditCard = new CreditCard(
               NUMERO, Integer.parseInt(MES), Integer.parseInt(ANIO), CODIGO
        );

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(ObjectToken.class, new TokenAdapter())
                .registerTypeAdapter(Credentials.class, new CredentialsAdapter())
                .registerTypeAdapter(CreditCard.class, new CreditCardAdapter())
                .registerTypeAdapter(Payment.class, new PaymentAdapter(new CreditCardAdapter()))
                .create();

        CreditCardService creditCardService = new HttpCreditCardService(
                gson
        );

        creditCardService.authenticate(userCredentials);

        //creditCardService.pay(creditCard, "Prueba desde Java [6]", 500);

        System.out.println(creditCardService.getBalance(creditCard));

        Loader userLoader = new UserLoader(UserService.getInstance());
        userLoader.load();

        launch();
    }
}