package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.screen.ScreenHandler;
import cl.ucn.ingsoftware.taller2.taller2.service.SessionService;
import cl.ucn.ingsoftware.taller2.taller2.service.ShoppingBasketService;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import cl.ucn.ingsoftware.taller2.taller2.validate.BasicFormFieldValidator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import cl.ucn.ingsoftware.taller2.taller2.validate.decorators.PointsValidatorDecorator;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

    private final ScreenHandler screenHandler = ScreenHandler.getInstance();

    private FormFieldValidator formFieldValidator;

    public TextField pointField;

    public PayPointsController() {
        formFieldValidator = new BasicFormFieldValidator();
        formFieldValidator = new PointsValidatorDecorator(formFieldValidator, sessionService.getSession(), shoppingBasketService.find(sessionService.getSession().getName()));
    }

    public void pay(ActionEvent event) throws IOException {
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

        user.removePoints(cost);

        shoppingBasket.notifyBought();
        shoppingBasket.clear();

        ((Node) (event.getSource())).getScene().getWindow().hide();
        screenHandler.show("voucher", "Boleta");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User user = sessionService.getSession();

        pointField.setText(
                Integer.toString(user.getPoints())
        );
    }

}
