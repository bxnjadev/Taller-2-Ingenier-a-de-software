package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBasketServiceImpl implements ShoppingBasketService {

    private static ShoppingBasketService SHOPPING_BASKET_SERVICE;

    private final Map<String, ShoppingBasket> baskets = new HashMap<>();

    @Override
    public void add(String username, ShoppingBasket shoppingBasket) {
        baskets.put(username, shoppingBasket);
    }

    @Override
    public void remove(String username) {
        baskets.remove(username);
    }

    @Override
    public ShoppingBasket find(String username) {
        return baskets.get(username);
    }

    public static ShoppingBasketService getInstance() {
        if (SHOPPING_BASKET_SERVICE == null) {
            SHOPPING_BASKET_SERVICE = new ShoppingBasketServiceImpl();
        }

        return SHOPPING_BASKET_SERVICE;
    }

}
