package cl.ucn.ingsoftware.taller2.taller2.util;

import javafx.scene.control.Alert;

import java.util.Scanner;

public class AlertMessage {

    public static void show(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
