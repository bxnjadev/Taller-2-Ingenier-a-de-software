package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.authenticate.*;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import cl.ucn.ingsoftware.taller2.taller2.util.AlertMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthenticationController {

    public Button button;
    @FXML
    private TextField mail;

    @FXML
    private TextField password;

    private final Authenticator authenticator;

    public AuthenticationController() {
        UserService userService = UserService.getInstance();

        AuthenticatorFactory authenticatorFactory =
                new DefaultAuthenticatorFactory(userService);

        authenticator = authenticatorFactory.get(AuthenticatorType.BASIC);
    }

    public void handleLogin() {

        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();

        Credentials credentials = new Credentials(mail.getText(),
                password.getText());

        AuthenticationResponse response = authenticator.authenticate(
                credentials
        );

        if (response.isFailed()) {
            AlertMessage.show(Alert.AlertType.ERROR, "Iniciar sesión", "Usuario o contraseña incorrecta :(");
            return;
        }

        AlertMessage.show(Alert.AlertType.INFORMATION, "Iniciar sesión", "Inicio de sesión existoso!");

    }

}
