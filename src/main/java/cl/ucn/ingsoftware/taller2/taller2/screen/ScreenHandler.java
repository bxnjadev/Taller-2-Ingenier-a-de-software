package cl.ucn.ingsoftware.taller2.taller2.screen;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class ScreenHandler {

    private static ScreenHandler SCREEN_HANDLER;

    private final Map<String, Scene> screens =
            new HashMap<>();

    private final Stage stage;

    private ScreenHandler(Stage stage) {
        this.stage = stage;
    }

    public void register(String name, Scene scene) {
        screens.put(name, scene);
    }

    public void show(String name) {
        Scene scene = screens.get(name);

        if (scene == null) {
            throw new IllegalArgumentException("The scene is null");
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
