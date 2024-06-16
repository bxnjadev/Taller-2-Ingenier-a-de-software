package cl.ucn.ingsoftware.taller2.taller2.model;

import java.util.ArrayList;
import java.util.List;

public class Voucher {

    private final String id;
    private final String date;
    private final String expiredDate;
    private final List<String> services;

    public Voucher(String id,
                   String date,
                   String expiredDate,
                   List<String> services) {
        this.id = id;
        this.date = date;
        this.expiredDate = expiredDate;
        this.services = services;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public List<String> getServices() {
        return new ArrayList<>(services);
    }

    /**
     * Return a brief description of this credit card, the exact details
     * of the representation are unspecified and subjects change,
     * but the following be regarded as typical:
     * "[id = a3fg, date = 15/06/2024 20:40, expire_date = 15/12/2024 20:40]"
     */

    @Override
    public String toString() {
        return String.format(
                "[id = %s, date = %s, expire_date = %s]",
                id,
                date,
                expiredDate
        );
    }

}
