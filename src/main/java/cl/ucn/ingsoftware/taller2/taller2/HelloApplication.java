package cl.ucn.ingsoftware.taller2.taller2;

import cl.ucn.ingsoftware.taller2.taller2.util.DefaultReader;
import cl.ucn.ingsoftware.taller2.taller2.util.Reader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Reader reader = new DefaultReader(
                HelloApplication.class.getResourceAsStream("users.json")
        );

        System.out.println(reader.readLine());
        System.out.println(reader.readLine());

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}