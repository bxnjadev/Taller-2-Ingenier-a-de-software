package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.service.ServicesRegistry;
import cl.ucn.ingsoftware.taller2.taller2.util.AlertMessage;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HandleServicesController implements Initializable {

    private static final String EMPTY = "";

    public TextField serviceField;
    public TextField price;

    @FXML
    public TableColumn<Service, String> columnName;

    @FXML
    public TableColumn<Service, String> columnPrice;

    @FXML
    public TableView<Service> table;



    private final ServicesRegistry servicesRegistry
            = ServicesRegistry.getServicesRegistry();


    @FXML
    public void onAdd() {

        String s = serviceField.getText();

        Service service = new Service(
                serviceField.getText(),
                price.getText()
        );

        table.getItems()
                .add(service);

    }

    @FXML
    public void onRemove() {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnName.setCellValueFactory(
                new PropertyValueFactory<Service, String>("columnName")
        );

        columnPrice.setCellValueFactory(
                new PropertyValueFactory<Service, String>("columnPrice")
        );

    }

}
