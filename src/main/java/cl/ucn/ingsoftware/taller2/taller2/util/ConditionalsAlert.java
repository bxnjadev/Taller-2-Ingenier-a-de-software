package cl.ucn.ingsoftware.taller2.taller2.util;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ConditionalsAlert {

    private static final Alert.AlertType ALERT_ERROR = Alert.AlertType.ERROR;

    private ConditionalsAlert() {
        throw new IllegalArgumentException();
    }

    /**
     * Check if a set text fields are empty if is true, send a message error
     * @param errorMessage the message error content
     * @param fields the set fields
     * @return true if empty
     */

    public static boolean checkIfEmptyAndShow(
            String errorMessage,
            TextField... fields
    ) {
        boolean isEmpty = false;
        StringBuilder stringBuilder = new StringBuilder();

        for (TextField field : fields) {
            String value = field.getText();

            if (value.isEmpty()) {
                System.out.println(value);
                isEmpty = true;
                stringBuilder.append(
                        errorMessage.replace("%field%", field.getPromptText())
                ).append("\n");
            }

        }

        if (isEmpty) {
            AlertMessage.show(
                    ALERT_ERROR,
                    "Error",
                    stringBuilder.toString()
            );
        }

        return isEmpty;
    }

    /**
     * Validate a condition, if this condition is true show a
     * message in a windows
     * @param condition the condition
     * @param errorMessage the message error content
     * @return true if the condition is valid
     */

    public static boolean checkAndShow(boolean condition,
                                       String errorMessage) {
        if (!condition) {
            AlertMessage.show(
                    ALERT_ERROR,
                    "Error",
                    errorMessage
            );
        }
        return condition;
    }

}
