package effective.mobile.task_management_system.validation.impl;

import effective.mobile.task_management_system.validation.ValidEnumValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEnumValueValidator implements ConstraintValidator<ValidEnumValue, Enum<?>> {

    private Enum<?>[] validValues;

    @Override
    public void initialize(ValidEnumValue constraintAnnotation) {
        this.validValues = constraintAnnotation.value().getEnumConstants();
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {

        for (Enum<?> validValue : validValues) {
            if (validValue.equals(value)) {
                return true;
            }
        }
        return false;
    }
}