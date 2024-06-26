package cl.ucn.ingsoftware.taller2.taller2.validate.decorators;

import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import cl.ucn.ingsoftware.taller2.taller2.util.ConditionalsAlert;
import cl.ucn.ingsoftware.taller2.taller2.validate.AbstractFormFieldValidatorDecorator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import javafx.scene.control.TextField;

import java.util.Map;

/**
 * This is a decorator class that check if a mail is valid
 */

public class MailFieldValidatorDecorator extends AbstractFormFieldValidatorDecorator {

    private final UserService userService;

    public MailFieldValidatorDecorator(FormFieldValidator formFieldValidator,
                                       UserService userService) {
        super(formFieldValidator);
        this.userService = userService;
    }

    /**
     * Check if a mail is valid
     * @param fields the map fields, where String is the name field and TextField the value field
     * @return true if a mail is valid
     */

    @Override
    public boolean validate(Map<String, TextField> fields) {
        if (!formFieldValidator.validate(fields)) {
            return false;
        }

        String mail = fields.get("mail").
                getText();

        return ConditionalsAlert.checkAndShow(
                userService.findByMail(mail) == null,
                "el correo electrónico ingresado ya existe en el sistema"
        );
    }

}
