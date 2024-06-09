package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;

public interface ShoppingBasketService {

    void add(String username, ShoppingBasket shoppingBasket);

    void remove(String username);

    ShoppingBasket find(String username);

    static ShoppingBasketService getInstance() {
        return ShoppingBasketServiceImpl.getInstance();
    }

}
