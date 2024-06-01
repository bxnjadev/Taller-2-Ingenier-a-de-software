package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.adapter.CredentialsAdapter;
import cl.ucn.ingsoftware.taller2.taller2.adapter.CreditCardAdapter;
import cl.ucn.ingsoftware.taller2.taller2.adapter.PaymentAdapter;
import cl.ucn.ingsoftware.taller2.taller2.adapter.TokenAdapter;
import cl.ucn.ingsoftware.taller2.taller2.authenticate.Credentials;
import cl.ucn.ingsoftware.taller2.taller2.model.CreditCard;
import cl.ucn.ingsoftware.taller2.taller2.model.ObjectToken;
import cl.ucn.ingsoftware.taller2.taller2.model.Payment;
import cl.ucn.ingsoftware.taller2.taller2.service.CreditCardService;
import cl.ucn.ingsoftware.taller2.taller2.util.AlertMessage;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreditCardController {

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(ObjectToken.class, new TokenAdapter())
            .registerTypeAdapter(Credentials.class, new CredentialsAdapter())
            .registerTypeAdapter(CreditCard.class, new CreditCardAdapter())
            .registerTypeAdapter(Payment.class, new PaymentAdapter(new CreditCardAdapter()))
            .create();

    public TextField creditCardNumber;
    public TextField dateExpireMoth;
    public TextField dateExpireYear;
    public TextField cvc;

    private CreditCardService creditCardService =
            CreditCardService.http();

    public void pay() throws IOException, InterruptedException {

        CreditCard creditCard = new CreditCard(cvc.getText(),
                Integer.parseInt(dateExpireMoth.getText()),
                Integer.parseInt(dateExpireYear.getText()),
                creditCardNumber.getText()
        );

        boolean validate = creditCardService.validate(creditCard);
        if (!validate) {
            AlertMessage.show(
                    Alert.AlertType.ERROR,
                    "Error",
                    "Tarjeta no valida"
            );
        }

    }

}
