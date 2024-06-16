package cl.ucn.ingsoftware.taller2.taller2.validate;

/**
 * This class focus the decorator design patterns, using this method
 * we can add more validators form basic validator, in this way,
 * our validation model is more simple and easy to attach
 */

public abstract class AbstractFormFieldValidatorDecorator implements FormFieldValidator {

    protected final FormFieldValidator formFieldValidator;

    public AbstractFormFieldValidatorDecorator(FormFieldValidator formFieldValidator) {
        this.formFieldValidator = formFieldValidator;
    }

}
