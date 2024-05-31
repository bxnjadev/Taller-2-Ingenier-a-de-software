package cl.ucn.ingsoftware.taller2.taller2.buy;

import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.model.User;

import java.util.HashSet;
import java.util.Set;

public class ShoppingBasket {

    private final Set<Service> services;
    private final User user;

    public ShoppingBasket(User user) {
        services = new HashSet<>();
        this.user = user;
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void removeService(Service service) {
        services.remove(service);
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

}
