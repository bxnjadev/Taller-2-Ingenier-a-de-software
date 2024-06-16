package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.MainApplication;
import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.register.RegisterService;
import cl.ucn.ingsoftware.taller2.taller2.register.StatusRegister;
import cl.ucn.ingsoftware.taller2.taller2.screen.ScreenHandler;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import cl.ucn.ingsoftware.taller2.taller2.validate.BasicFormFieldValidator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import cl.ucn.ingsoftware.taller2.taller2.validate.decorators.EqualsPasswordFieldValidatorDecorator;
import cl.ucn.ingsoftware.taller2.taller2.validate.decorators.MailFieldValidatorDecorator;
import cl.ucn.ingsoftware.taller2.taller2.validate.decorators.RangeFormFieldValidatorDecorator;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegisterSessionController {

    private static final RolType DEFAULT_ROL = RolType.USER;

    private Hyperlink loginHyperlink;

    private final UserService userService;
    private final ScreenHandler screenHandler = ScreenHandler.getInstance();

    FormFieldValidator formFieldValidator = new BasicFormFieldValidator();

    public TextField name;
    public TextField age;
    public TextField mail;
    public PasswordField passwordField;
    public PasswordField passwordRepeatField;
    public Button button;

    public RegisterSessionController() {
        userService = UserService.getInstance();

        formFieldValidator = new RangeFormFieldValidatorDecorator(formFieldValidator);
        formFieldValidator = new MailFieldValidatorDecorator(formFieldValidator, userService);
        formFieldValidator = new EqualsPasswordFieldValidatorDecorator(formFieldValidator);
    }

    public void handleRegister(ActionEvent event) throws IOException {


        RegisterService registerService = RegisterService
                .getInstance(userService);

        Map<String, TextField> fields = new HashMap<>();
        fields.put("name", name);
        fields.put("age", age);
        fields.put("mail", mail);
        fields.put("password", passwordField);
        fields.put("passwordRepeat", passwordRepeatField);

        if (!formFieldValidator.validate(fields)) {
            return;
        }

        StatusRegister statusRegister = registerService.register(
                name.getText(), Integer.parseInt(age.getText()),
                mail.getText(), passwordField.getText(),
                passwordRepeatField.getText(),
                DEFAULT_ROL
        );

        ((Node)(event.getSource())).getScene().getWindow().hide();
        screenHandler.show("login", "Iniciar Sesión");
    }

    public void loginHyperlink(ActionEvent event) throws IOException {
        screenHandler.show(
                "login", "Iniciar Sesión"
        );


        ((Node)(event.getSource())).getScene().getWindow().hide();


    }

}
