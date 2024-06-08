package cl.ucn.ingsoftware.taller2.taller2.util;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ConditionalsAlert {

    private static final Alert.AlertType ALERT_ERROR = Alert.AlertType.ERROR;

    private ConditionalsAlert() {

    }

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

    public static boolean executeAndShowIfThrow(Runnable runnable,
                                                String errorMessage) {

        try {
            runnable.run();
            return true;
        } catch (Exception e) {
            AlertMessage.show(
                    ALERT_ERROR,
                    "Error",
                    errorMessage
            );
            return false;
        }

    }

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
