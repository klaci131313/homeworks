package com.kovacslaszlo.beans;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Laci
 */
public class MobileTypeTest {

    private static ValidatorFactory vf;
    private static Validator validator;
    private MobileType mobileType;

    @Before
    public void beforeTest() {
        mobileType = new MobileType("123456789123456789123456789123456789",
                Manufacturer.APPLE, "6smini", 160000, Currency.EUR, Color.BLUE);
    }

    @BeforeClass
    public static void init() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }

    @AfterClass
    public static void close() {
        vf.close();
    }

    @Test
    public void testGoodColorSamsung() {
        Color goodColor = Color.WHITE;
        mobileType.setColor(goodColor);
        mobileType.setManufacturer(Manufacturer.SAMSUNG);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(mobileType);
        assertEquals(0, violations.size());
    }

    @Test
    public void testInvalideColorSasmung() {
        Color invalideColor = Color.GREEN;
        mobileType.setColor(invalideColor);
        mobileType.setManufacturer(Manufacturer.SAMSUNG);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(mobileType);
        assertEquals(1, violations.size());

        ConstraintViolation<MobileType> violation = violations.iterator().next();
        assertEquals("{CustomColor.message}", violation.getMessageTemplate());
    }

    @Test
    public void testGoodColorApple() {
        Color goodColor = Color.WHITE;
        mobileType.setColor(goodColor);
        mobileType.setManufacturer(Manufacturer.APPLE);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(mobileType);
        assertEquals(0, violations.size());
    }

    @Test
    public void testInvalideColorApple() {
        Color invalideColor = Color.RED;
        mobileType.setColor(invalideColor);
        mobileType.setManufacturer(Manufacturer.APPLE);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(mobileType);
        assertEquals(1, violations.size());

        ConstraintViolation<MobileType> violation = violations.iterator().next();
        assertEquals("{CustomColor.message}", violation.getMessageTemplate());
    }
}
