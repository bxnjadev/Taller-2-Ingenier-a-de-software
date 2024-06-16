package cl.ucn.ingsoftware.taller2.taller2.screen;

import cl.ucn.ingsoftware.taller2.taller2.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class manage all screen program
 */

public class ScreenHandler {

    private static ScreenHandler SCREEN_HANDLER;

    private ScreenHandler() {
    }

    /**
     * Show a new screen
     * @param name the name screen
     * @param title the title screen
     */

    public void show(String name, String title) {

        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(
                name + ".fxml"
        ));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();

    }

    public static ScreenHandler getInstance() {

        if (SCREEN_HANDLER == null) {
            SCREEN_HANDLER = new ScreenHandler();
        }

        return SCREEN_HANDLER;
    }

}
