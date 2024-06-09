package cl.ucn.ingsoftware.taller2.taller2.buy;

import cl.ucn.ingsoftware.taller2.taller2.buy.observers.AccumulatePointServiceBuyObserver;
import cl.ucn.ingsoftware.taller2.taller2.buy.observers.CreatePurchaseBuyObserver;
import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.model.User;

import java.util.HashSet;
import java.util.Set;

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

    public void addService(Service service) {
        services.add(service);
    }

    public void removeService(Service service) {
        services.remove(service);
    }

    public void clear() {
        services.clear();
    }

    public Set<Service> getServices() {
        return services;
    }

    public User getUser() {
        return user;
    }

    public double calculatePrice() {
        double price = 0;

        for (Service service : services) {
            price += service.getPrice();
        }

        return price;
    }

    public void notifyBought() {
        for (ServicesBuyObserver servicesBuyObserver : observers) {
            servicesBuyObserver.buy(this);
        }
    }

}
