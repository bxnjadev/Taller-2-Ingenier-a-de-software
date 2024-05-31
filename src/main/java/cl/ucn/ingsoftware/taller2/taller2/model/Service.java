package cl.ucn.ingsoftware.taller2.taller2.model;

public class Service {

    private String name;
    private int price;

    public Service(String name,
                   int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
