package cl.ucn.ingsoftware.taller2.taller2.validate;

public abstract class AbstractFormFieldValidatorDecorator implements FormFieldValidator {

    protected final FormFieldValidator formFieldValidator;

    public AbstractFormFieldValidatorDecorator(FormFieldValidator formFieldValidator) {
        this.formFieldValidator = formFieldValidator;
    }

}
