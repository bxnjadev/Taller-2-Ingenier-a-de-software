package cl.ucn.ingsoftware.taller2.taller2.util;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ConditionalsAlert {

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

        if(isEmpty){
            AlertMessage.show(
                    Alert.AlertType.ERROR,
                    "Error",
                    stringBuilder.toString()
            );
        }

        return isEmpty;
    }

}
