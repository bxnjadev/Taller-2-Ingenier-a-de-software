package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.confirmation.AlertConfirmation;
import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.screen.ScreenHandler;
import cl.ucn.ingsoftware.taller2.taller2.service.ServicesRegistry;
import cl.ucn.ingsoftware.taller2.taller2.service.SessionService;
import cl.ucn.ingsoftware.taller2.taller2.util.AlertMessage;
import cl.ucn.ingsoftware.taller2.taller2.validate.BasicFormFieldValidator;
import cl.ucn.ingsoftware.taller2.taller2.validate.FormFieldValidator;
import cl.ucn.ingsoftware.taller2.taller2.validate.decorators.MoneyFieldValidatorDecorator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class HandleServicesController implements Initializable {

    private static final String EMPTY = "";

    public TextField serviceField;
    public TextField priceField;

    @FXML
    private TableColumn<Service, String> columnName;
    @FXML
    private TableColumn<Service, String> columnPrice;
    @FXML
    private TableView<Service> table;

    private FormFieldValidator formFieldValidator;

    private final ServicesRegistry servicesRegistry
            = ServicesRegistry.getServicesRegistry();

    private final SessionService sessionService = SessionService.getInstance();

    private final ScreenHandler screenHandler = ScreenHandler.
            getInstance();

    public HandleServicesController() {
        formFieldValidator = new BasicFormFieldValidator();
        formFieldValidator = new MoneyFieldValidatorDecorator(formFieldValidator);
    }

    @FXML
    public void onAdd() {

        Map<String, TextField> fields = new HashMap<>();
        fields.put("serviceField", serviceField);
        fields.put("priceField", priceField);

        if (!formFieldValidator.validate(fields)) {
            return;
        }

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

        AlertConfirmation.createAndShow(
                () -> {
                    Service service = new Service(
                            serviceName,
                            Integer.parseInt(priceField.getText())
                    );

                    table.getItems()
                            .add(service);

                    servicesRegistry.add(service);
                    clear(serviceField, priceField);
                }
        );


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

        AlertConfirmation.createAndShow(
                () -> {
                    table.getItems().remove(service);

                    servicesRegistry.delete(
                            serviceName
                    );

                    clear(serviceField, priceField);
                }
        );

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnName.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        columnPrice.setCellValueFactory(
                new PropertyValueFactory<>("price")
        );

        for (Service service : servicesRegistry.all()) {
            table.getItems()
                    .add(service);
        }

    }

    private void clear(TextField... textFields) {
        for (TextField textField : textFields) {
            textField.clear();
        }
    }

    public void onExit(ActionEvent event) {
        sessionService.close();

        ((Node) (event.getSource())).getScene().getWindow().hide();
        screenHandler.show("login", "Iniciar sesión");
    }

    public void onEdit() {
        String serviceName = serviceField.getText()
                .trim();

        Service service = servicesRegistry.find(serviceName);

        if (service == null) {
            AlertMessage.show(
                    Alert.AlertType.ERROR,
                    "Error",
                    "No hay un registro llamado así"
            );
            return;
        }

        AlertConfirmation.createAndShow(
                () -> {

                    table.getItems()
                            .remove(service);

                    service.setPrice(
                            Integer.parseInt(priceField.getText())
                    );

                    table.getItems()
                            .add(service);



                    clear(serviceField, priceField);
                }
        );

    }

}
