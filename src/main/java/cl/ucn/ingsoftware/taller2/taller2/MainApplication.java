package cl.ucn.ingsoftware.taller2.taller2;

import cl.ucn.ingsoftware.taller2.taller2.loader.*;
import cl.ucn.ingsoftware.taller2.taller2.screen.ScreenHandler;
import cl.ucn.ingsoftware.taller2.taller2.service.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) {

        MainLoader mainLoader = new MainLoader();

        ScreenHandler screenHandler = ScreenHandler.getInstance();

        mainLoader.addAll(
                new UserLoader(UserService.getInstance()),
                new ServiceLoader(ServicesRegistry.getServicesRegistry()),
                new SceneLoader(stage),
                new CreditCardServiceLoader(CreditCardService.http())
        );

        mainLoader.load();

        screenHandler.show("login", "Iniciar Sesión");

    }

    public static void main(String[] args) {
        launch();
    }

}