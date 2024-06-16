package cl.ucn.ingsoftware.taller2.taller2.validate;

import javafx.scene.control.TextField;

import java.util.Map;

/**
 * This class represent a form validator
 */

public interface FormFieldValidator {

    /**
     * Validate if a field is valid based on criteria
     * @param fields the map fields, where String is the name field and TextField the value field
     * @return true if the field is validated
     */

    boolean validate(Map<String, TextField> fields);


}
