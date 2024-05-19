package cl.ucn.ingsoftware.taller2.taller2.model;

public class CreditCard {

    private final String number;
    private final int mouth;
    private final int year;
    private final String code;

    public CreditCard(String number,
                      int mouth,
                      int year,
                      String code) {
        this.number = number;
        this.mouth = mouth;
        this.year = year;
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public int getMouth() {
        return mouth;
    }

    public String getCode() {
        return code;
    }

    public int getYear() {
        return year;
    }


}
