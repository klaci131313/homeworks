/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import com.laszlokovacs.Color;
import com.laszlokovacs.MobileType;
import constraint.CustomColor;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Laci
 */
public class CustomColorValidator implements ConstraintValidator<CustomColor, MobileType> {

    @Override
    public void initialize(CustomColor constraintAnnotation) {
        throw new UnsupportedOperationException("Not supported yet.");
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
