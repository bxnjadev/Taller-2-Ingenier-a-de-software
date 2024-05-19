package cl.ucn.ingsoftware.taller2.taller2.model;

public class Payment {

    private final CreditCard creditCard;
    private final String description;
    private final int amount;

    public Payment(CreditCard creditCard,
                   String description,
                   int amount) {
        this.creditCard = creditCard;
        this.description = description;
        this.amount = amount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

}
