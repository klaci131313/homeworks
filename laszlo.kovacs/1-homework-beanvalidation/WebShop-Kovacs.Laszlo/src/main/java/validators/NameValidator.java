package validators;

import constraint.Name;
import dto.UserDTO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Laci
 */
public class NameValidator implements ConstraintValidator<Name, UserDTO> {

    @Override
    public void initialize(Name constraintAnnotation) {
        //Do nothing
    }

    @Override
    public boolean isValid(UserDTO value, ConstraintValidatorContext context) {
        String lastName = value.getLastName();
        String firstName = value.getFirstName();
        return (firstName == null && lastName == null)
                || (firstName != null && lastName != null);

    }
}
