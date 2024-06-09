package cl.ucn.ingsoftware.taller2.taller2.controllers;

import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.service.SessionService;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PayPointsController implements Initializable {

    private final SessionService sessionService = SessionService.
            getInstance();

    public TextField pointField;

    public void pay() {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User user = sessionService.getSession();

        pointField.setText(
                Integer.toString(user.getPoints())
        );
    }

}
