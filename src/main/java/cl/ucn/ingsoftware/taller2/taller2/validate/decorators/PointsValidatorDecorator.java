package cl.ucn.ingsoftware.taller2.taller2.validate.decorators;

import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.util.ConditionalsAlert;
import cl.ucn.ingsoftware.taller2.taller2.validate.AbstractFormFieldValidatorDecorator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import javafx.scene.control.TextField;

import java.util.Map;

/**
 * This is a decorator class that check if a user has enough
 */

public class PointsValidatorDecorator extends AbstractFormFieldValidatorDecorator {

    private final ShoppingBasket shoppingBasket;
    private final User user;
    public PointsValidatorDecorator(FormFieldValidator formFieldValidator, User user, ShoppingBasket shoppingBasket) {
        super(formFieldValidator);
        this.shoppingBasket = shoppingBasket;
        this.user = user;
    }

    /**
     * Check if a field has point enough
     * @param fields the map fields, where String is the name field and TextField the value field
     * @return true if a points is enough
     */

    @Override
    public boolean validate(Map<String, TextField> fields) {
        if (!formFieldValidator.validate(fields)) {
            return false;
        }

        double points = user.getPoints();

        return ConditionalsAlert.checkAndShow(
                points >= shoppingBasket.calculatePrice(),
                "cantidad de puntos insuficientes"
        );

    }
}
