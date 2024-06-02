package cl.ucn.ingsoftware.taller2.taller2.model;

import java.util.Locale;

public class Service {

    private final String name;
    private final int price;

    public Service(String name,
                   int price) {
        this.name = name.toLowerCase(Locale.ROOT);
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
