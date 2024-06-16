package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.authenticate.Authenticator;
import cl.ucn.ingsoftware.taller2.taller2.authenticate.Credentials;
import cl.ucn.ingsoftware.taller2.taller2.model.CreditCard;
import com.google.gson.Gson;

import java.io.IOException;

/**
 * This class represent the credit card service for
 * manage operations with the credit card system
 */

public interface CreditCardService {

    /**
     * Authenticate with the system
     * @param credentials the credentials data
     * @throws IOException main exception
     * @throws InterruptedException exception with system
     */

    void authenticate(Credentials credentials) throws IOException, InterruptedException;

    /**
     * Validate if credit card is valid
     * @param creditCard the credit card data
     * @return true if the credit card is available
     * @throws IOException main exception
     * @throws InterruptedException
     */

    boolean validate(CreditCard creditCard) throws IOException, InterruptedException;

    /**
     * Provide the credit card balance
     * @param creditCard the credit card data
     * @return the balance
     * @throws IOException main exception
     * @throws InterruptedException
     */

    double getBalance(CreditCard creditCard) throws IOException, InterruptedException;

    /**
     * Check if is authenticated with system
     * @return true if is authenticated
     */

    boolean isAuthenticated();

    /**
     * Make a transaction in the system
     * @param creditCard the credit card data
     * @param description the description
     * @param amount the amount
     * @return true if the transaction is successful
     * @throws IOException main exception
     * @throws InterruptedException
     */

    boolean pay(CreditCard creditCard,
                String description,
                int amount) throws IOException, InterruptedException;

    static CreditCardService http() {
        return HttpCreditCardService.getInstance();
    }

}
