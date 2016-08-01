package com.laszlokovacs.webshop.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import com.laszlokovacs.webshop.validators.NameValidator;

/**
 *
 * @author Laci
 */
@Constraint(validatedBy = {NameValidator.class})
@Retention(RUNTIME)
@Target({FIELD, PARAMETER, TYPE})
@ReportAsSingleViolation

public @interface Name {

    String message() default "{Name.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
