package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.service.ServicesRegistry;
import cl.ucn.ingsoftware.taller2.taller2.util.AlertMessage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HandleServicesController implements Initializable {

    private static final String EMPTY = "";

    public TextField serviceField;
    public TextField priceField;

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

        String serviceName = serviceField.getText()
                .trim();

        if (servicesRegistry.exists(serviceName)) {
            AlertMessage.show(
                    Alert.AlertType.ERROR,
                    "Error",
                    "Ya hay un registro llamado así"
            );
            return;
        }

        Service service = new Service(
                serviceName,
                Integer.parseInt(priceField.getText())
        );

        table.getItems()
                .add(service);

        servicesRegistry.add(service);
        clear(serviceField, priceField);
    }

    @FXML
    public void onRemove() {
        String serviceName = serviceField.getText();
        Service service = servicesRegistry.find(serviceName);

        if (service == null) {
            AlertMessage.show(
                    Alert.AlertType.ERROR,
                    "Error",
                    "No hay un registro llamado así"
            );
            return;
        }


        table.getItems().remove(service);

        servicesRegistry.delete(
                serviceName
        );

        clear(serviceField, priceField);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnName.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        columnPrice.setCellValueFactory(
                new PropertyValueFactory<>("price")
        );

    }

    private void clear(TextField... textFields) {
        for (TextField textField : textFields) {
            textField.clear();
        }
    }

}
