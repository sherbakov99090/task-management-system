package effective.mobile.task_management_system.validation;

import effective.mobile.task_management_system.validation.impl.ValidEnumValueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidEnumValueValidator.class)
public @interface ValidEnumValue {
    Class<? extends Enum<?>> value(); // Указываем конкретный тип перечисления
    String message() default "Неподдерживаемое значение для данного поля";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

