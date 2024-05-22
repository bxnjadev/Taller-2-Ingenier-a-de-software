package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.register.RegisterService;
import cl.ucn.ingsoftware.taller2.taller2.register.StatusRegister;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterSessionController {

    private static final RolType DEFAULT_ROL = RolType.USER;

    public TextField name;
    public TextField age;
    public TextField mail;
    public TextField password;
    public TextField repeatPassword;
    public Button button;

    public void handleRegister() {

        UserService userService = UserService
                .getInstance();

        RegisterService registerService = RegisterService
                .getInstance(userService);

        int ageAsInt = Integer.parseInt(age.getText());
        String passwordValue = password.getText();
        String passwordRepeatValue = repeatPassword.getText();

        if (!passwordValue.equals(passwordRepeatValue)) {
            //  Inform password are not equals
            return;
        }

        StatusRegister statusRegister = registerService.register(
                name.getText(), ageAsInt,
                mail.getText(), passwordValue,
                passwordRepeatValue,
                DEFAULT_ROL
        );


    }

}
