package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.authenticate.Authenticator;
import cl.ucn.ingsoftware.taller2.taller2.authenticate.Credentials;
import cl.ucn.ingsoftware.taller2.taller2.model.CreditCard;

import java.io.IOException;

public interface CreditCardService {

    void authenticate(Credentials credentials) throws IOException, InterruptedException;

    boolean validate(CreditCard creditCard) throws IOException, InterruptedException;

    double getBalance(CreditCard creditCard) throws IOException, InterruptedException;

    boolean isAuthenticated();

    void pay(CreditCard creditCard,
             String description,
             int amount);

}
