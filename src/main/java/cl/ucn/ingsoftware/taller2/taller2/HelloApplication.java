package cl.ucn.ingsoftware.taller2.taller2;

import cl.ucn.ingsoftware.taller2.taller2.authenticate.Credentials;
import cl.ucn.ingsoftware.taller2.taller2.adapter.CredentialsAdapter;
import cl.ucn.ingsoftware.taller2.taller2.adapter.CreditCardAdapter;
import cl.ucn.ingsoftware.taller2.taller2.adapter.PaymentAdapter;
import cl.ucn.ingsoftware.taller2.taller2.adapter.TokenAdapter;
import cl.ucn.ingsoftware.taller2.taller2.loader.Loader;
import cl.ucn.ingsoftware.taller2.taller2.loader.ServiceLoader;
import cl.ucn.ingsoftware.taller2.taller2.loader.UserLoader;
import cl.ucn.ingsoftware.taller2.taller2.model.*;
import cl.ucn.ingsoftware.taller2.taller2.service.*;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class HelloApplication extends Application {

    private static final String CODIGO = "567";
    private static final String MES = "10";
    private static final String ANIO = "2027";
    private static final String NUMERO = "4386297350841657";

    private static final String USERNAME = "bmiranda11";
    private static final String PASSWORD = "678234";

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("credit_card.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws IOException, InterruptedException {


        Credentials userCredentials =
                new Credentials(USERNAME, PASSWORD);

        CreditCard creditCard = new CreditCard(
                NUMERO, Integer.parseInt(MES), Integer.parseInt(ANIO), CODIGO
        );

        CreditCardService creditCardService = CreditCardService.http();
        creditCardService.authenticate(userCredentials);

        SessionService.getInstance()
                        .newSession(
                                new User("Juan", 20, "sjid", "wdjsd", RolType.USER, 3000
                                )
                        );

        System.out.println(creditCardService.getBalance(creditCard));

        Loader userLoader = new UserLoader(UserService.getInstance());
        userLoader.load();

        Loader serviceLoader = new ServiceLoader(
                ServicesRegistry.getServicesRegistry()
        );
        serviceLoader.load();

        launch();
    }
}