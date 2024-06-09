package cl.ucn.ingsoftware.taller2.taller2.model;

import java.util.Set;

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

    public int getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public Set<String> servicesName() {
        return servicesName;
    }

}
