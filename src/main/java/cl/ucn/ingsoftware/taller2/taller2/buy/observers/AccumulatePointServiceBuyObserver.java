package cl.ucn.ingsoftware.taller2.taller2.buy.observers;

import cl.ucn.ingsoftware.taller2.taller2.buy.MethodPay;
import cl.ucn.ingsoftware.taller2.taller2.buy.ServicesBuyObserver;
import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;
import cl.ucn.ingsoftware.taller2.taller2.model.User;

/**
 * A observer when is executed a user bough a service
 */

public class AccumulatePointServiceBuyObserver implements ServicesBuyObserver {

    private static final double PERCENTAGE = 0.2;

    /**
     * Provide a percentage in points
     * @param shoppingBasket the shoppingBasket object
     * @param methodPay the method pay object
     */

    @Override
    public void buy(ShoppingBasket shoppingBasket,
                    MethodPay methodPay) {

        if (methodPay != MethodPay.CREDIT_CARD) {
            return;
        }

        User user = shoppingBasket.getUser();
        int points = (int) Math.round(shoppingBasket.calculatePrice() * PERCENTAGE);

        user.addPoints(
                points
        );

    }

}
