package cl.ucn.ingsoftware.taller2.taller2.loader;

import cl.ucn.ingsoftware.taller2.taller2.authenticate.Credentials;
import cl.ucn.ingsoftware.taller2.taller2.model.CreditCard;
import cl.ucn.ingsoftware.taller2.taller2.service.CreditCardService;

import java.io.IOException;

public class CreditCardServiceLoader implements Loader {

    private static final String USERNAME = "bmiranda11";
    private static final String PASSWORD = "678234";

    private final CreditCardService creditCardService;

    public CreditCardServiceLoader(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public void load() {

        Credentials userCredentials =
                new Credentials(USERNAME, PASSWORD);

        try {
            creditCardService.authenticate(userCredentials);
            System.out.println("[CREDIT CARD]: Authenticated with credit card service");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
