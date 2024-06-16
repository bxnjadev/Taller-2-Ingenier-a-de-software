package cl.ucn.ingsoftware.taller2.taller2.validate.decorators;

import cl.ucn.ingsoftware.taller2.taller2.util.ConditionalsAlert;
import cl.ucn.ingsoftware.taller2.taller2.validate.AbstractFormFieldValidatorDecorator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import javafx.scene.control.TextField;

import java.util.Map;

/**
 * This is a decorator class that check field money is up 300 CLP
 */

public class MoneyFieldValidatorDecorator extends AbstractFormFieldValidatorDecorator {

    public MoneyFieldValidatorDecorator(FormFieldValidator formFieldValidator) {
        super(formFieldValidator);
    }

    /**
     * Check if a field money is up 300 CLP
     * @param fields the map fields, where String is the name field and TextField the value field
     * @return true if a money is up 300 CLP
     */

    @Override
    public boolean validate(Map<String, TextField> fields) {
        if (!formFieldValidator.validate(fields)) {
            return false;
        }

        String price = fields.get("priceField").getText();

        int priceInt = Integer.parseInt(price);

        return ConditionalsAlert.checkAndShow(
                priceInt >= 300,
                "el precio del servicio no puede ser inferior a 300 pesos chilenos");
    }
}
