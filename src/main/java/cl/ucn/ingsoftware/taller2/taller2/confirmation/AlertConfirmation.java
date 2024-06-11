package cl.ucn.ingsoftware.taller2.taller2.confirmation;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertConfirmation {

    private final Alert alert;
    private ActionConfirmationExecutor actionConfirmationExecutor;

    public AlertConfirmation(ActionConfirmationExecutor actionConfirmationExecutor) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        this.actionConfirmationExecutor = actionConfirmationExecutor;

        configure();
        showAndWait();
    }

    public void configure() {
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("¿Estás seguro de confirmar la acción?");
    }

    public void showAndWait() {
        Optional<ButtonType> action = alert.showAndWait();

        if (action.isPresent()) {
            ButtonType type = action.get();

            if (type == ButtonType.OK) {
                actionConfirmationExecutor.execute();
            }

        }
    }

    public static AlertConfirmation createAndShow(
            ActionConfirmationExecutor actionConfirmationExecutor
    ) {
        return new AlertConfirmation(actionConfirmationExecutor);
    }


}
