package cl.ucn.ingsoftware.taller2.taller2.model;

import java.util.Locale;

/**
 * This is a class value that represent a service acquired for clients
 */

public class Service {

    private final String name;
    private int price;

    public Service(String name,
                   int price) {
        this.name = name.toLowerCase(Locale.ROOT);
        this.price = price;
    }

    /**
     * Return the string representation of the name
     * the service
     *
     * @return the service nmae
     */

    public String getName() {
        return name;
    }

    /**
     * Return the price value of the service
     *
     * @return the price
     */

    public int getPrice() {
        return price;
    }

    /**
     * Update the price of service
     *
     * @param price the new price
     */

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Calculate the hash code
     * @return the hash code
     */

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Integer.hashCode(price);

        return result;
    }

    /**
     * Compare if two services are equals
     * @param obj the object service
     * @return true if is equals
     */

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Service service)) {
            return false;
        }

        return service.price == price && service.name.equals(name);
    }

    /**
     * Return a brief description of this credit card, the exact details
     * of the representation are unspecified and subjects change,
     * but the following be regarded as typical:
     * "[ = 5652354345 mouth = 3, code = 56532345, year = 3]"
     */

    @Override
    public String toString() {
        return String.format(
                "[name = %s, price = %d]",
                name,
                price
        );
    }
}
