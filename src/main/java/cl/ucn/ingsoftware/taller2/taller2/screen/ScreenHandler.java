package cl.ucn.ingsoftware.taller2.taller2.screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ScreenHandler {

    private static ScreenHandler SCREEN_HANDLER;

    private final Map<String, ScreenModel> screens =
            new HashMap<>();

    private final Stage stage;

    private ScreenHandler(Stage stage) {
        this.stage = stage;
    }

    public void register(String name,  ScreenModel modelScreen) {
        screens.put(name, modelScreen);
    }

    public void show(String name) {
        ScreenModel modelScreen = screens.get(name);

        if (modelScreen == null) {
            throw new IllegalArgumentException("The scene is null");
        }

        FXMLLoader loader = modelScreen.getLoader();

        Scene scene = null;
        try {
            scene = new Scene(loader.load(),
                    modelScreen.getV1(),
                    modelScreen.getV2());
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(scene);
        stage.show();
    }

    public static ScreenHandler buildByScene(Stage stage) {
        if (SCREEN_HANDLER == null) {
            SCREEN_HANDLER = new ScreenHandler(stage);
        }

        return SCREEN_HANDLER;
    }

    public static ScreenHandler getInstance() {
        return SCREEN_HANDLER;
    }

}
