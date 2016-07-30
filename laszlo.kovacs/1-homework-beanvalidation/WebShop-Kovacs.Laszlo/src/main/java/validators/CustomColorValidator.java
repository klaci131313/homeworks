package validators;

import enums.Color;
import dto.MobileType;
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
