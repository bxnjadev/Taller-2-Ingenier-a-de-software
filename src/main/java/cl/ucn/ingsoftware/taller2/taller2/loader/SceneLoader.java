package cl.ucn.ingsoftware.taller2.taller2.loader;

import cl.ucn.ingsoftware.taller2.taller2.MainApplication;
import cl.ucn.ingsoftware.taller2.taller2.screen.ScreenHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader implements Loader {

    private final ScreenHandler screenHandler;

    public SceneLoader(Stage stage) {
        screenHandler = ScreenHandler.buildByScene(stage);
    }

    @Override
    public void load() {

        screenHandler.register("login", buildScene(
                "login.fxml", 400, 300
        ));

        screenHandler.register("register", buildScene(
                "register.fxml", 150, 300
        ));

        screenHandler.register("handle_services", buildScene(
                "handle_services.fxml", 500, 400
        ));

        screenHandler.register("buy_gift_card", buildScene(
                "buy_gift_card.fxml", 500, 500
        ));

        screenHandler.register("credit_card", buildScene(
                "credit_card.fxml", 300, 300
        ));

    }

    private Scene buildScene(String fileName,
                             int v, int v1) {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fileName));
        try {
            return new Scene(fxmlLoader.load(), v, v1);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
