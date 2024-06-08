package cl.ucn.ingsoftware.taller2.taller2.validate.decorators;

import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import cl.ucn.ingsoftware.taller2.taller2.util.ConditionalsAlert;
import cl.ucn.ingsoftware.taller2.taller2.validate.AbstractFormFieldValidatorDecorator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import javafx.scene.control.TextField;

import java.util.Map;

public class MailIncorrectFieldValidatorDecorator extends AbstractFormFieldValidatorDecorator {

    private final UserService userService;
    public MailIncorrectFieldValidatorDecorator(FormFieldValidator formFieldValidator,
                                                UserService userService) {
        super(formFieldValidator);
        this.userService = userService;
    }

    @Override
    public boolean validate(Map<String, TextField> fields) {
        if (!formFieldValidator.validate(fields)) {
            return false;
        }

        String password = fields.get("password").getText();
        String mail = fields.get("mail").getText();

        return ConditionalsAlert.checkAndShow(
                userService.findByMail(mail) != null,
                "usuario no registrado o contraseña incorrecta"
        );
    }

}
