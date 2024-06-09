package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;
import cl.ucn.ingsoftware.taller2.taller2.model.Purchase;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.screen.ScreenHandler;
import cl.ucn.ingsoftware.taller2.taller2.service.RecentPurchaseService;
import cl.ucn.ingsoftware.taller2.taller2.service.SessionService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class VoucherController  implements Initializable {

    private final SessionService sessionService = SessionService.
            getInstance();

    private final RecentPurchaseService recentPurchaseService = RecentPurchaseService
            .getInstance();

    private final ScreenHandler screenHandler = ScreenHandler.getInstance();

    public Label date;
    public Label dateExpiration;
    public Label code;
    public ListView<String> services;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User user = SessionService.getInstance().
                getSession();

        Purchase purchase = recentPurchaseService.find(
                user
        );

        date.setText(purchase.getDate());
        dateExpiration.setText(purchase.getExpireDate());
        code.setText(Integer.toString(purchase.getCode()));

        services.getItems()
                .addAll(purchase.servicesName());

        recentPurchaseService.delete(user);

    }


    public void retry(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        screenHandler.show("buy_gift_card", "Comprar una gift card");
    }

}
