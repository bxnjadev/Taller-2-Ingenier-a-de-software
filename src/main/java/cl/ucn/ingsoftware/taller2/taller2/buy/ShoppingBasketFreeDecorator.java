package cl.ucn.ingsoftware.taller2.taller2.buy;

import cl.ucn.ingsoftware.taller2.taller2.model.User;

public class ShoppingBasketFreeDecorator extends ShoppingBasket {

    public ShoppingBasketFreeDecorator(ShoppingBasket shoppingBasket) {
        super(shoppingBasket.getUser());
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

}
