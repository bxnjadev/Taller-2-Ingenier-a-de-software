package cl.ucn.ingsoftware.taller2.taller2.model;

import java.util.Objects;
import java.util.Set;

/**
 * This is a class value that represent a purchase make in the service
 */

public class Purchase {

    private final int code;
    private final String date;
    private final String expireDate;
    private final Set<String> servicesName;

    public Purchase(int code,
                    String date,
                    String expireDate,
                    Set<String> servicesName) {
        this.code = code;
        this.date = date;
        this.expireDate = expireDate;
        this.servicesName = servicesName;
    }

    /**
     * The code purchase
     * @return the code
     */

    public int getCode() {
        return code;
    }

    /**
     * The date in format: "[dd/mm/yyyy hh:mm]"
     * @return the date
     */

    public String getDate() {
        return date;
    }

    /**
     * The expire date in format: "[dd/MM/yyyy HH:mm]"
     * @return the date
     */

    public String getExpireDate() {
        return expireDate;
    }

    /**
     * A collection of services
     * @return the services
     */

    public Set<String> servicesName() {
        return servicesName;
    }

    /**
     * Calculate the hash code
     * @return the hash code
     */

    @Override
    public int hashCode() {
        int result = Integer.hashCode(code);
        result = 31 * result + date.hashCode();
        result = 31 * result + expireDate.hashCode();

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

        if (!(obj instanceof Purchase purchase)) {
            return false;
        }

        return purchase.code == code &&
                purchase.date.equals(date) &&
                purchase.expireDate.equals(expireDate);
    }

    /**
     * Return a brief description of this credit card, the exact details
     * of the representation are unspecified and subjects change,
     * but the following be regarded as typical:
     * "[code = 32171785, date = 15/06/2024 20:40, expire_date = 15/12/2024 20:40]"
     */

    @Override
    public String toString() {
        return String.format(
                "[code = %d, date = %s, expire_date = %s]",
                code,
                date,
                expireDate
        );
    }

}
