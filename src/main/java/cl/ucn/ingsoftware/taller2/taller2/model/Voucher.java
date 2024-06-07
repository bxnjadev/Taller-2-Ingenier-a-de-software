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

}
