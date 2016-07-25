/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constraint;

import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Laci
 */
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@Size(min = 6)
@Pattern.List({
    @Pattern(regexp = ".*([0-9])|[\\.\\,\\<\\>\\=\\+]+"),
    @Pattern(regexp = ".*[a-z].*"),
    @Pattern(regexp = ".*[A-Z].*"),})

public @interface Password {

    String message() default "{Password.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
