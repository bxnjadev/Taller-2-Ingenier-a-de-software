package cl.ucn.ingsoftware.taller2.taller2.validate;

import javafx.scene.control.TextField;

import java.util.Map;

public interface FormFieldValidator {

    boolean validate(Map<String, TextField> fields);


}
