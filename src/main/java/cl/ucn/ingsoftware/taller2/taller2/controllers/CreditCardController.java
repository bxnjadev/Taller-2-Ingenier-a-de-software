package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.adapter.CredentialsAdapter;
import cl.ucn.ingsoftware.taller2.taller2.adapter.CreditCardAdapter;
import cl.ucn.ingsoftware.taller2.taller2.adapter.PaymentAdapter;
import cl.ucn.ingsoftware.taller2.taller2.adapter.TokenAdapter;
import cl.ucn.ingsoftware.taller2.taller2.authenticate.Credentials;
import cl.ucn.ingsoftware.taller2.taller2.buy.MethodPay;
import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;
import cl.ucn.ingsoftware.taller2.taller2.model.CreditCard;
import cl.ucn.ingsoftware.taller2.taller2.model.ObjectToken;
import cl.ucn.ingsoftware.taller2.taller2.model.Payment;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.screen.ScreenHandler;
import cl.ucn.ingsoftware.taller2.taller2.service.CreditCardService;
import cl.ucn.ingsoftware.taller2.taller2.service.SessionService;
import cl.ucn.ingsoftware.taller2.taller2.service.ShoppingBasketService;
import cl.ucn.ingsoftware.taller2.taller2.util.AlertMessage;
import cl.ucn.ingsoftware.taller2.taller2.validate.BasicFormFieldValidator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreditCardController {

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(ObjectToken.class, new TokenAdapter())
            .registerTypeAdapter(Credentials.class, new CredentialsAdapter())
            .registerTypeAdapter(CreditCard.class, new CreditCardAdapter())
            .registerTypeAdapter(Payment.class, new PaymentAdapter(new CreditCardAdapter()))
            .create();

    public TextField creditCardNumber;
    public TextField dateExpireMonth;
    public TextField dateExpireYear;
    public TextField cvc;

    private final CreditCardService creditCardService =
            CreditCardService.http();

    private final ShoppingBasketService shoppingBasketService =
            ShoppingBasketService.getInstance();

    private final SessionService sessionService =
            SessionService.getInstance();

    private final ScreenHandler screenHandler = ScreenHandler.getInstance();
    private final FormFieldValidator formFieldValidator;

    public CreditCardController() {
        formFieldValidator = new BasicFormFieldValidator();
    }

    public void pay(ActionEvent event) throws IOException, InterruptedException {

        Map<String, TextField> fields = new HashMap<>();
        fields.put("cvc", cvc);
        fields.put("creditCardNumber", creditCardNumber);
        fields.put("dateExpireMoth", dateExpireMonth);
        fields.put("dateExpireYear", dateExpireYear);

        if (!formFieldValidator.validate(
                fields
        )) {
            return;
        }

        User userSession = sessionService.getSession();
        ShoppingBasket shoppingBasket = shoppingBasketService.find(
                userSession.getName()
        );


        CreditCard creditCard = new CreditCard(creditCardNumber.getText(),
                Integer.parseInt(dateExpireMonth.getText()),
                Integer.parseInt(dateExpireYear.getText()),
                cvc.getText()
        );

        boolean validate = creditCardService.validate(creditCard);
        if (!validate) {
            AlertMessage.show(
                    Alert.AlertType.ERROR,
                    "Error",
                    "Tarjeta no valida"
            );
            return;
        }

        int cost = (int) shoppingBasket.calculatePrice();

        creditCardService.pay(
                creditCard,
                "COMPRA",
                cost
        );

        shoppingBasket.notifyBought(MethodPay.CREDIT_CARD);
        shoppingBasket.clear();

        ((Node) (event.getSource())).getScene().getWindow().hide();
        screenHandler.show("voucher", "Boleta");

    }

}
