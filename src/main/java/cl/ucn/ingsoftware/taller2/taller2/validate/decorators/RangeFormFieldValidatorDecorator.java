package cl.ucn.ingsoftware.taller2.taller2.validate.decorators;

import cl.ucn.ingsoftware.taller2.taller2.util.ConditionalsAlert;
import cl.ucn.ingsoftware.taller2.taller2.validate.AbstractFormFieldValidatorDecorator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import javafx.scene.control.TextField;

import java.util.Map;

/**
 * This is a decorator class that check if a value is in range
 */

public class RangeFormFieldValidatorDecorator extends AbstractFormFieldValidatorDecorator {

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 65;

    public RangeFormFieldValidatorDecorator(FormFieldValidator formFieldValidator) {
        super(formFieldValidator);
    }

    /**
     * Check if a number is in range 18 and 65
     * @param fields the map fields, where String is the name field and TextField the value field
     * @return true if a number is in range 18 and 65
     */

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
