package cl.ucn.ingsoftware.taller2.taller2.validate.decorators;

import cl.ucn.ingsoftware.taller2.taller2.util.ConditionalsAlert;
import cl.ucn.ingsoftware.taller2.taller2.validate.AbstractFormFieldValidatorDecorator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import javafx.scene.control.TextField;

import java.util.Map;

public class RangeFormFieldValidatorDecorator extends AbstractFormFieldValidatorDecorator {

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 65;

    public RangeFormFieldValidatorDecorator(FormFieldValidator formFieldValidator) {
        super(formFieldValidator);
    }

    @Override
    public boolean validate(Map<String, TextField> fields) {
        if (!formFieldValidator.validate(fields)) {
            return false;
        }

        int ageAsInt = Integer.parseInt(
                fields.get("age").getText()
        );

        System.out.println("Age: " + ageAsInt);

        return ConditionalsAlert.checkAndShow(
                MIN_AGE <= ageAsInt && ageAsInt <= MAX_AGE,
                "la edad no puede ser inferior a 18 y mayor a 65"
        );
    }
}
