package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;

/**
 * This class represent a registry all shopping basket registered
 * as this application is only a client, we need a only one user
 * in all application
 */

public interface ShoppingBasketService {

    /**
     * Add a new username in the shopping basket registry
     * @param username the username
     * @param shoppingBasket the object shopping basket
     */

    void add(String username, ShoppingBasket shoppingBasket);

    /**
     * Remove a shopping based in a username
     * @param username the username shopping basket to deleted
     */

    void remove(String username);

    /**
     * Find a shopping basket
     * @param username the username
     * @return the object shopping basket
     */

    ShoppingBasket find(String username);

    static ShoppingBasketService getInstance() {
        return ShoppingBasketServiceImpl.getInstance();
    }

}
