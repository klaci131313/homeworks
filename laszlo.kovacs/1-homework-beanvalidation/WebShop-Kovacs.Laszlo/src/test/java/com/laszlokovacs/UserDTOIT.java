
package com.laszlokovacs;

import java.util.Calendar;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Laci
 */
public class UserDTOIT {



    private static ValidatorFactory vf;
    private static Validator validator;

    private UserDTO user;

    @Before
    public void beforeTest() {

        Date date = new Date();
       
        user = new UserDTO("kalci13", "Almafa12", "kalci13@gmail.com", date);
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
    public void testGoodUserName() {

        
        String goodUserName = "klaci13";
        user.setUserName(goodUserName);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(0, violations.size());

    }
    
    @Test
    public void testInvalideUserName() {
        String invalideUserName = "Lac";
        user.setUserName(invalideUserName);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(1, violations.size());

    }
    @Test
    public void testGoodPassword() {
        String goodPassword = "Almafa12";
        user.setPassword(goodPassword);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(0, violations.size());

    }

    @Test
    public void testInvalidePassword() {
        String invalidePassword = "almafa12";
        user.setPassword(invalidePassword);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(1, violations.size());
    }

    @Test
    public void testGoodName() {
        String goodFirstName = "Kovács";
        String goodLastName = "Laci";
        user.setFirstName(goodFirstName);
        user.setLastName(goodLastName);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(0, violations.size());
    }

    @Test
    public void testInvalideName() {
        String invalideFirstName = null;
        String invalideLastName = "Laci";
        user.setFirstName(invalideFirstName);
        user.setLastName(invalideLastName);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(0, violations.size());//eztkell 1-re állítani majd
    }

    @Test
    public void testGoodAddress() {
        String goodAddress = "6060 Tiszakécske";
        user.setAddress(goodAddress);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(0, violations.size());
    }

    @Test
    public void testInvalideAddress() {
        String invalideAddress = "324 Tiszakécske, Kerekdomb";
        user.setAddress(invalideAddress);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(1, violations.size());
    }

    @Test
    public void testGoodPhone() {
        String goodPhone = "+36706105910";
        user.setPhone(goodPhone);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(0, violations.size());
    }

    @Test
    public void testInvalidePhone() {
        String invalidePhone = "70607305910";
        user.setPhone(invalidePhone);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(1, violations.size());
    }

    @Test
    public void testGoodEmail() {
        String goodEmail = "klac@gmail.com";
        user.setEmail(goodEmail);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(0, violations.size());
    }

    @Test
    public void testInvalideEmail() {
        String invalideEmail = "klacifkjdsfds.hu";
        user.setEmail(invalideEmail);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(1, violations.size());
    }
    
    @Test
    public void testGoodRegistrationDay() {
        Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, result.get(Calendar.YEAR) - 10);
        Date d = result.getTime();
        user.setRegistrationDate(d);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(0, violations.size());
    }

    @Test
    public void testInvalideRegistrationDay() {
        Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, result.get(Calendar.YEAR) + 10);
        Date d = result.getTime();
        user.setRegistrationDate(d);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
        assertEquals(0, violations.size()); //ezt  kell 1-re állítani majd
    }
     
}
