/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import com.laszlokovacs.UserDTO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import constraint.RegistrationDay;

/**
 *
 * @author Laci
 */
public class RegistrationDayValidator implements ConstraintValidator<RegistrationDay, UserDTO> {

    @Override
    public void initialize(RegistrationDay constraintAnnotation) {
        ////Do nothing 

    }

    @Override
    public boolean isValid(UserDTO value, ConstraintValidatorContext context) {

        if (value.getDateOfBirth() == null) {
            return true;
        } else {
            return value.getDateOfBirth().getTime()
                    < value.getRegistrationDate().getTime();
        }

    }
}
