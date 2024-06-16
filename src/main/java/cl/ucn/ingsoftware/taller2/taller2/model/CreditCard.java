package cl.ucn.ingsoftware.taller2.taller2.model;

import java.util.Objects;

/**
 * This class value that represent a credit card
 */

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

    /**
     * Return the card number
     *
     * @return the card number
     */

    public String getNumber() {
        return number;
    }

    /**
     * Return the mouth is valid credit card
     *
     * @return the mouth
     */

    public int getMouth() {
        return mouth;
    }

    /**
     * Return the code card
     *
     * @return the code card
     */

    public String getCode() {
        return code;
    }

    /**
     * Return the year expire the card
     *
     * @return the year expire card
     */

    public int getYear() {
        return year;
    }

    /**
     * Calculate the hash code
     * @return the hash code
     */

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + Integer.hashCode(mouth);
        result = 31 * result + code.hashCode();
        result = 31 * result + Objects.hashCode(year);

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

        if (!(obj instanceof CreditCard creditCard)) {
            return false;
        }

        return creditCard.code.equals(code) &&
                creditCard.number.equals(number) &&
                creditCard.year == year &&
                creditCard.mouth == mouth;
    }

    /**
     * Return a brief description of this credit card, the exact details
     * of the representation are unspecified and subjects change,
     * but the following be regarded as typical:
     * "[number = 5652354345, mouth = 3, code = 56532345, year = 2027]"
     */

    @Override
    public String toString() {
        return String.format("[number = %s, mouth = %d, code = %s, year = %d]",
                number,
                mouth,
                code,
                year);
    }

}
