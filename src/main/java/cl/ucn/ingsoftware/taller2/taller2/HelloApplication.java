package cl.ucn.ingsoftware.taller2.taller2;

import cl.ucn.ingsoftware.taller2.taller2.authenticate.*;
import cl.ucn.ingsoftware.taller2.taller2.loader.Loader;
import cl.ucn.ingsoftware.taller2.taller2.loader.UserLoader;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import cl.ucn.ingsoftware.taller2.taller2.service.UserServiceImpl;
import cl.ucn.ingsoftware.taller2.taller2.util.DefaultReader;
import cl.ucn.ingsoftware.taller2.taller2.util.Reader;
import cl.ucn.ingsoftware.taller2.taller2.util.StringReaderAdapter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
    }
}