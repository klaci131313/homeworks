package com.kovacslaszlo.validators;

import com.kovacslaszlo.beans.Color;
import com.kovacslaszlo.beans.MobileType;
import com.kovacslaszlo.constraint.CustomColor;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Laci
 */
public class CustomColorValidator implements ConstraintValidator<CustomColor, MobileType> {

    @Override
    public void initialize(CustomColor constraintAnnotation) {
        //Do nothing
    }

    @Override
    public boolean isValid(MobileType value, ConstraintValidatorContext context) {
        switch (value.getManufacturer()) {
            case APPLE:
                return value.getColor() == Color.BLACK
                        || value.getColor() == Color.WHITE;
            case SAMSUNG:
                return value.getColor() != Color.GREEN;

            default:
                return true;
        }
    }
}
