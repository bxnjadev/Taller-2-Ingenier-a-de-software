package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.service.ServicesRegistry;
import cl.ucn.ingsoftware.taller2.taller2.util.AlertMessage;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Locale;

public class HandleServicesController {

    private static final String EMPTY = "";

    @FXML
    public TextField serviceField;

    @FXML
    private ListView<String> services;

    private final ServicesRegistry servicesRegistry
            = ServicesRegistry.getServicesRegistry();


    @FXML
    public void onAdd() {

        String serviceName = serviceField.getText().toLowerCase(Locale.ROOT);

        ObservableList<String> observableList = services.getItems();

        if (servicesRegistry.exists(serviceName)) {
            AlertMessage.show(Alert.AlertType.ERROR, "Error", "Servicio ya existente!");
            return;
        }


        observableList.add(serviceName);
        servicesRegistry.add(serviceName);

        cleanTextField();
    }

    @FXML
    public void onRemove() {

        String serviceName = serviceField.getText().toLowerCase(Locale.ROOT);
        ObservableList<String> observableList = services.getItems();

        if (!servicesRegistry.exists(serviceName)) {
            AlertMessage.show(Alert.AlertType.ERROR, "Error", "Servicio no existente!");
            return;
        }

        servicesRegistry.delete(serviceName);
        observableList.remove(serviceName);

        cleanTextField();
    }

    private void cleanTextField() {
        serviceField.setText(EMPTY);
    }

}
