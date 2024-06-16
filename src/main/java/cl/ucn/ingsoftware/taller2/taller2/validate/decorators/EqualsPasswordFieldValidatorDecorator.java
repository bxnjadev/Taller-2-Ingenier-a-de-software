package cl.ucn.ingsoftware.taller2.taller2.validate.decorators;

import cl.ucn.ingsoftware.taller2.taller2.util.ConditionalsAlert;
import cl.ucn.ingsoftware.taller2.taller2.validate.AbstractFormFieldValidatorDecorator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import javafx.scene.control.TextField;

import java.util.Map;

/**
 * This is a decorator class that check if two password are equals
 */

public class EqualsPasswordFieldValidatorDecorator extends AbstractFormFieldValidatorDecorator {

    public EqualsPasswordFieldValidatorDecorator(FormFieldValidator formFieldValidator) {
        super(formFieldValidator);
    }

    /**
     * Check if two password are equals
     * @param fields the map fields, where String is the name field and TextField the value field
     * @return true if the two password are equals
     */

    @Override
    public boolean validate(Map<String, TextField> fields) {
        if (!formFieldValidator.validate(fields)) {
            return false;
        }

        String password = fields.get("password").getText();
        String passwordRepeat = fields.get("passwordRepeat").getText();

        System.out.println(password);
        System.out.println(passwordRepeat);

        return ConditionalsAlert.checkAndShow(
                password.equals(passwordRepeat),
                "las contraseñas ingresadas no coinciden"
        );
    }

}
