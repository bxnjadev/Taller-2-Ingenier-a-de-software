package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.authenticate.*;
import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.screen.ScreenHandler;
import cl.ucn.ingsoftware.taller2.taller2.service.SessionService;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import cl.ucn.ingsoftware.taller2.taller2.util.AlertMessage;
import cl.ucn.ingsoftware.taller2.taller2.util.ConditionalsAlert;
import cl.ucn.ingsoftware.taller2.taller2.validate.BasicFormFieldValidator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import cl.ucn.ingsoftware.taller2.taller2.validate.decorators.MailFieldValidatorDecorator;
import cl.ucn.ingsoftware.taller2.taller2.validate.decorators.MailIncorrectFieldValidatorDecorator;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationController {

    @FXML private Button button;
    @FXML private TextField mail;
    @FXML private TextField password;

    private FormFieldValidator formFieldValidator;
    private final Authenticator authenticator;

    private final ScreenHandler screenHandler = ScreenHandler.
            getInstance();

    private final SessionService sessionService = SessionService.
            getInstance();

    public AuthenticationController() {
        UserService userService = UserService.getInstance();

        AuthenticatorFactory authenticatorFactory =
                new DefaultAuthenticatorFactory(userService);

        authenticator = authenticatorFactory.get(AuthenticatorType.BASIC);

        formFieldValidator = new BasicFormFieldValidator();
        formFieldValidator = new MailIncorrectFieldValidatorDecorator(formFieldValidator,
                userService);
    }

    public void clickHyperlink() {
        screenHandler.show("register");
    }

    public void handleLogin() {

        Map<String, TextField> fields = new HashMap<>();
        fields.put("mail", mail);
        fields.put("password", password);

        if (!formFieldValidator.validate(fields)) {
            return;
        }

        Credentials credentials = new Credentials(mail.getText(),
                password.getText());

        AuthenticationResponse response = authenticator.authenticate(
                credentials
        );

        if (response.isFailed()) {
            AlertMessage.show(Alert.AlertType.ERROR, "Error", "usuario no registrado o contraseña incorrecta");
            return;
        }

        User userAuthenticated = response.getUser();
        sessionService.newSession(userAuthenticated);

        if (userAuthenticated.getRolType() == RolType.ADMINISTRATOR) {
            screenHandler.show("handle_services");
            return;
        }
        screenHandler.show("buy_gift_card");
    }

}
