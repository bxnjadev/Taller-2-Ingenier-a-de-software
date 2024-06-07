package cl.ucn.ingsoftware.taller2.taller2.loader;

import cl.ucn.ingsoftware.taller2.taller2.MainApplication;
import cl.ucn.ingsoftware.taller2.taller2.screen.ScreenModel;
import cl.ucn.ingsoftware.taller2.taller2.screen.ScreenHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class SceneLoader implements Loader {

    private final ScreenHandler screenHandler;

    public SceneLoader(Stage stage) {
        screenHandler = ScreenHandler.buildByScene(stage);
    }

    @Override
    public void load() {

        screenHandler.register("login", buildModelScreen(
                "login.fxml", 400, 300
        ));

        screenHandler.register("register", buildModelScreen(
                "register.fxml", 150, 300
        ));

        screenHandler.register("handle_services", buildModelScreen(
                "handle_services.fxml", 500, 400
        ));

        screenHandler.register("buy_gift_card", buildModelScreen(
                "buy_gift_card.fxml", 500, 500
        ));

        screenHandler.register("credit_card", buildModelScreen(
                "credit_card.fxml", 300, 300
        ));

    }

    private ScreenModel buildModelScreen(String fileName,
                                         int v, int v1) {
        return new ScreenModel(
                new FXMLLoader(MainApplication.class.getResource(fileName)),
                v,
                v1
        );
    }

}
