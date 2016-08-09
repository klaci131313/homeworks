package com.laszlokovacs.webshop.db;

import com.laszlokovacs.webshop.beans.UserDTO;
import com.laszlokovacs.webshop.db.exceptions.UsernameAlreadyExistsException;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laci
 */
public class UserDBTest {

    @Test
    public void testRegistrate() {
        Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, result.get(Calendar.YEAR) + 10);
        Date date = result.getTime();
        UserDTO userDTO = new UserDTO("klaci13", "Almafa12", "klaci13@gmail.com", date);
        UserDB userDB = new UserDB();
        userDB.registrate(userDTO);

        assertEquals(userDTO, userDB.getUser(userDTO.getUserName()));
    }

    @Test(expected = UsernameAlreadyExistsException.class)
    public void testRegistrateAlreadyUserExists() {
        Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, result.get(Calendar.YEAR) + 10);
        Date date = result.getTime();
        UserDTO userDTO = new UserDTO("klaci13", "Almafa12", "klaci13@gmail.com", date);
        UserDB userDB = new UserDB();
        userDB.registrate(userDTO);
        userDB.registrate(userDTO);
    }

    @Test
    public void testAuthenticate() {
        Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, result.get(Calendar.YEAR) + 10);
        Date date = result.getTime();
        UserDTO userDTO = new UserDTO("klaci13", "Almafa12", "klaci13@gmail.com", date);
        UserDB userDB = new UserDB();
        userDB.registrate(userDTO);

        assertEquals(true, userDB.authenticate("klaci13", "Almafa12"));
    }

    @Test
    public void testAuthenticateWrongPassword() {
        Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, result.get(Calendar.YEAR) + 10);
        Date date = result.getTime();
        UserDTO userDTO = new UserDTO("klaci13", "Almafa12", "klaci13@gmail.com", date);
        UserDB userDB = new UserDB();
        userDB.registrate(userDTO);

        assertEquals(false, userDB.authenticate("klaci13", "Kortefa12"));
    }

    @Test
    public void testAuthenticateWrongUsername() {
        Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, result.get(Calendar.YEAR) + 10);
        Date date = result.getTime();
        UserDTO userDTO = new UserDTO("klaci13", "Almafa12", "klaci13@gmail.com", date);
        UserDB userDB = new UserDB();
        userDB.registrate(userDTO);

        assertEquals(false, userDB.authenticate("tomi13", "Almafa12"));
    }

    @Test
    public void testGetUser() {
        Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, result.get(Calendar.YEAR) + 10);
        Date date = result.getTime();
        UserDTO userDTO = new UserDTO("klaci13", "Almafa12", "klaci13@gmail.com", date);
        UserDB userDB = new UserDB();
        userDB.registrate(userDTO);

        assertEquals(userDTO, userDB.getUser(userDTO.getUserName()));
    }

    @Test
    public void testGetInvalidUser() {
        Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, result.get(Calendar.YEAR) + 10);
        Date date = result.getTime();
        UserDTO userDTO = new UserDTO("klaci13", "Almafa12", "klaci13@gmail.com", date);
        UserDB userDB = new UserDB();

        assertEquals(null, userDB.getUser(userDTO.getUserName()));
    }
}
