package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.service.SessionService;
import cl.ucn.ingsoftware.taller2.taller2.service.ShoppingBasketService;
import cl.ucn.ingsoftware.taller2.taller2.validate.BasicFormFieldValidator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PayPointsController implements Initializable {

    private final SessionService sessionService = SessionService.
            getInstance();

    private final ShoppingBasketService shoppingBasketService =
            ShoppingBasketService.getInstance();

    private final FormFieldValidator formFieldValidator;

    public TextField pointField;

    public PayPointsController() {
        formFieldValidator = new BasicFormFieldValidator();
    }

    public void pay() {
        Map<String, TextField> fields = new HashMap<>();
        fields.put("pointField", pointField);

        if (!formFieldValidator.validate(
                fields
        )) {
            return;
        }

        User user = sessionService.getSession();
        ShoppingBasket shoppingBasket = shoppingBasketService.find(
                user.getName()
        );

        int cost = (int) shoppingBasket.calculatePrice();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User user = sessionService.getSession();

        pointField.setText(
                Integer.toString(user.getPoints())
        );
    }

}
