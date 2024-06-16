package cl.ucn.ingsoftware.taller2.taller2.validate;

import cl.ucn.ingsoftware.taller2.taller2.util.ConditionalsAlert;
import javafx.scene.control.TextField;

import java.util.Collection;
import java.util.Map;

/**
 * This class represent the main and basic form validator
 */

public class BasicFormFieldValidator implements FormFieldValidator {

    private static final TextField[] TEXT_FIELDS = new TextField[]{};

    /**
     * Validate if a field is valid check if the fields are empty
     * @param fields the map fields, where String is the name field and TextField the value field
     * @return true if the field is validated
     */

    @Override
    public boolean validate(Map<String, TextField> fields) {
        Collection<TextField> collection = fields.values();
        TextField[] fieldsAsArray =  collection.toArray(TEXT_FIELDS);

        return !ConditionalsAlert.checkIfEmptyAndShow(
                "debe completar el campo %field%",
                fieldsAsArray
        );

    }

}
