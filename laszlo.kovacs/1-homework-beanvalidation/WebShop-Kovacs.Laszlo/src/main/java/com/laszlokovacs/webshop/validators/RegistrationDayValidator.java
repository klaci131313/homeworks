package com.laszlokovacs.webshop.validators;

import com.laszlokovacs.webshop.beans.UserDTO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.laszlokovacs.webshop.constraint.RegistrationDay;

/**
 *
 * @author Laci
 */
public class RegistrationDayValidator implements ConstraintValidator<RegistrationDay, UserDTO> {

    @Override
    public void initialize(RegistrationDay constraintAnnotation) {
        //Do nothing 
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
