package cl.ucn.ingsoftware.taller2.taller2.buy.observers;

import cl.ucn.ingsoftware.taller2.taller2.buy.MethodPay;
import cl.ucn.ingsoftware.taller2.taller2.buy.ServicesBuyObserver;
import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;
import cl.ucn.ingsoftware.taller2.taller2.model.User;

public class AccumulatePointServiceBuyObserver implements ServicesBuyObserver {

    private static final double PERCENTAGE = 0.2;

    @Override
    public void buy(ShoppingBasket shoppingBasket,
                    MethodPay methodPay) {

        if (methodPay != MethodPay.CREDIT_CARD) {
            return;
        }

        User user = shoppingBasket.getUser();
        int points = (int) Math.round(shoppingBasket.calculatePrice() * PERCENTAGE);

        System.out.println("[ACUMULADOR DE PUNTOS] : " + points);

        user.addPoints(
                points
        );

    }

}
