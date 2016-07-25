/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import validators.RegistrationDayValidator;

/**
 *
 * @author Laci
 */
@Target({ElementType.TYPE})
@Constraint(validatedBy = {RegistrationDayValidator.class})
@ReportAsSingleViolation
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface RegistrationDay {

    String message() default "{RegistrationDay.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
