package com.kovacslaszlo.constraint;

import com.kovacslaszlo.validators.CustomColorValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

/**
 *
 * @author Laci
 */
@Target({ElementType.TYPE})
@Constraint(validatedBy = {CustomColorValidator.class})
@ReportAsSingleViolation
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomColor {

    String message() default "{CustomColor.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
