package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;
import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.screen.ScreenHandler;
import cl.ucn.ingsoftware.taller2.taller2.service.ServicesRegistry;
import cl.ucn.ingsoftware.taller2.taller2.service.SessionService;
import cl.ucn.ingsoftware.taller2.taller2.service.ShoppingBasketService;
import cl.ucn.ingsoftware.taller2.taller2.util.AlertMessage;
import cl.ucn.ingsoftware.taller2.taller2.validate.BasicFormFieldValidator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BuyGiftCardController implements Initializable {

    private static final double MIN_VALUE = 0.0;

    private final ServicesRegistry servicesRegistry = ServicesRegistry.
            getServicesRegistry();

    private final ShoppingBasketService shoppingBasketService =
            ShoppingBasketService.getInstance();

    private final ScreenHandler screenHandler =
            ScreenHandler.getInstance();

    public ListView<String> listView;
    public TextField priceField;

    private ShoppingBasket shoppingBasket;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        User user = SessionService.getInstance().getSession();

        shoppingBasket = shoppingBasketService.find(user.getName());

        if (shoppingBasket == null) {
            shoppingBasket = new ShoppingBasket(user);
            shoppingBasketService.add(
                    user.getName(), shoppingBasket
            );
        }

        priceField.setText(
                Double.toString(shoppingBasket.calculatePrice())
        );


        listView.
                getSelectionModel()
                .setSelectionMode(SelectionMode.MULTIPLE);

        for (Service service : servicesRegistry.all()) {
            String nameService = service.getName();
            listView.getItems().
                    add(nameService);
        }

        ObservableList<String> elements = listView.
                getSelectionModel().getSelectedItems();

        elements.addListener((ListChangeListener<? super String>) e -> {
            while (e.next()) {
                if (e.wasAdded()) {

                    for (String element : e.getAddedSubList()) {
                        Service service = servicesRegistry.find(element);

                        shoppingBasket.addService(
                                service
                        );

                    }
                }

                if (e.wasRemoved()) {

                    for (String element : e.getRemoved()) {
                        Service service = servicesRegistry.find(element);

                        shoppingBasket.removeService(
                                service
                        );
                    }

                }

                priceField.setText(
                        Double.toString(shoppingBasket.calculatePrice())
                );

            }
        });

    }


    public void onExit(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        screenHandler.show("login", "Iniciar sesión");
    }

    public boolean checkAmountAndShow() {
        double cost = shoppingBasket.calculatePrice();

        if (cost == MIN_VALUE) {
            AlertMessage.show(
                    Alert.AlertType.ERROR,
                    "Error",
                    "Debes seleccionar algún producto"
            );
            return false;
        }
        return true;
    }

    public void payCreditCard(ActionEvent event) {

        if (!checkAmountAndShow()) {
            return;
        }

        ((Node) (event.getSource())).getScene().getWindow().hide();
        screenHandler.show("credit_card", "Tarjeta de crédito");
    }

    public void payPoints(ActionEvent event) {

        if (!checkAmountAndShow()) {
            return;
        }

        ((Node) (event.getSource())).getScene().getWindow().hide();
        //screenHandler.show("", "Pagar por puntos");
    }

}
