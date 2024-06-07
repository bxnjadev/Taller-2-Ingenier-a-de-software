package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;
import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.service.ServicesRegistry;
import cl.ucn.ingsoftware.taller2.taller2.service.SessionService;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BuyGiftCardController implements Initializable {

    private final ServicesRegistry servicesRegistry = ServicesRegistry.
            getServicesRegistry();

    public ListView<String> listView;
    public TextField priceField;

    private ShoppingBasket shoppingBasket;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        shoppingBasket = new ShoppingBasket(
                SessionService.getInstance().getSession()
        );

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

}
