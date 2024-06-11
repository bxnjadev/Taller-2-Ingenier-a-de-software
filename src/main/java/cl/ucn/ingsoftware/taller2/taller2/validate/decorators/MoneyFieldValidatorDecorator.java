package cl.ucn.ingsoftware.taller2.taller2.validate.decorators;

import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import cl.ucn.ingsoftware.taller2.taller2.util.ConditionalsAlert;
import cl.ucn.ingsoftware.taller2.taller2.validate.AbstractFormFieldValidatorDecorator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import javafx.scene.control.TextField;

import java.util.Map;

public class MoneyFieldValidatorDecorator extends AbstractFormFieldValidatorDecorator {

    public MoneyFieldValidatorDecorator(FormFieldValidator formFieldValidator) {
        super(formFieldValidator);
    }

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
