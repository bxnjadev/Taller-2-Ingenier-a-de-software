package cl.ucn.ingsoftware.taller2.taller2.buy;

import cl.ucn.ingsoftware.taller2.taller2.buy.observers.AccumulatePointServiceBuyObserver;
import cl.ucn.ingsoftware.taller2.taller2.buy.observers.CreatePurchaseBuyObserver;
import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represent a Shopping Basket user, this contains all element
 * selected for realize a bought
 */

public class ShoppingBasket {

    private final Set<ServicesBuyObserver> observers;
    private final Set<Service> services;
    private final User user;

    public ShoppingBasket(User user) {
        services = new HashSet<>();
        observers = new HashSet<>();

        this.user = user;

        observers.add(
                new AccumulatePointServiceBuyObserver()
        );

        observers.add(
                new CreatePurchaseBuyObserver()
        );

    }

    /**
     * Add a new service to shopping basket
     * @param service the object service
     */

    public void addService(Service service) {
        services.add(service);
    }

    /**
     * Remove a service from shopping basket
     * @param service the object service to deleted
     */

    public void removeService(Service service) {
        services.remove(service);
    }

    /**
     * Clean all shopping basket
     */

    public void clear() {
        services.clear();
    }

    /**
     * Get inmutable service collection
     * @return service collection
     */

    public Set<Service> getServices() {
        return new HashSet<>(services);
    }

    /**
     * Get user owner shopping basket
     * @return the user object
     */

    public User getUser() {
        return user;
    }

    /**
     * Calculate the price about all shopping basket
     * @return a double that represent the price
     */

    public double calculatePrice() {
        double price = 0;

        for (Service service : services) {
            price += service.getPrice();
        }

        return price;
    }

    /**
     * Call all observers from this shopping basket
     * @param methodPay the method pay applier
     */

    public void notifyBought(MethodPay methodPay) {
        for (ServicesBuyObserver servicesBuyObserver : observers) {
            servicesBuyObserver.buy(this, methodPay);
        }
    }

}
