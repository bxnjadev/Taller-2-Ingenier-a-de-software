package cl.ucn.ingsoftware.taller2.taller2.model;

public class Service {

    private String name;
    private String price;

    public Service(String name,
                   String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

}
