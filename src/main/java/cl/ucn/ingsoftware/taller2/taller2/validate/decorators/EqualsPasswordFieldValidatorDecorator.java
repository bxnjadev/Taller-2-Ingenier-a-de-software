package cl.ucn.ingsoftware.taller2.taller2.validate.decorators;

import cl.ucn.ingsoftware.taller2.taller2.util.ConditionalsAlert;
import cl.ucn.ingsoftware.taller2.taller2.validate.AbstractFormFieldValidatorDecorator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import javafx.scene.control.TextField;

import java.util.Map;

public class EqualsPasswordFieldValidatorDecorator extends AbstractFormFieldValidatorDecorator {

    public EqualsPasswordFieldValidatorDecorator(FormFieldValidator formFieldValidator) {
        super(formFieldValidator);
    }

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
