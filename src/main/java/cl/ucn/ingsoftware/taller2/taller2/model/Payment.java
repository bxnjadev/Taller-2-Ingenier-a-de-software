package cl.ucn.ingsoftware.taller2.taller2.model;

/**
 * This class is value class that represent a payment make by client
 */

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

    /**
     * Return a credit card object, this credit card is associated with the proccess payment
     * @return the credit card
     */

    public CreditCard getCreditCard() {
        return creditCard;
    }

    /**
     * Return a string description of the payment, this description not have a additional information
     * @return the description
     */

    public String getDescription() {
        return description;
    }

    /**
     * Return a int amount of the payment
     * @return the amount
     */

    public int getAmount() {
        return amount;
    }

    /**
     * Return a brief description of this credit card, the exact details
     * of the representation are unspecified and subjects change,
     * but the following be regarded as typical:
     * "[credit_card = [number = 5652354345, mouth = 3, code = 56532345, year = 2027], description = a brief description, amount = 5000]""
     */

    @Override
    public String toString() {
        return String.format(
                "[credit_card = %s, description = %s, amount = %d]",
                creditCard.toString(),
                description,
                amount
        );
    }
}
