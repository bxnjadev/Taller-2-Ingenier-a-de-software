package cl.ucn.ingsoftware.taller2.taller2.buy;

/**
 * This class is a observer class
 */

public interface ServicesBuyObserver {

    /**
     * this method is executed
     * when a user bought services
     * @param shoppingBasket the shoppingBasket object
     * @param methodPay the method pay object
     */

    void buy(ShoppingBasket shoppingBasket,
             MethodPay methodPay);

}
