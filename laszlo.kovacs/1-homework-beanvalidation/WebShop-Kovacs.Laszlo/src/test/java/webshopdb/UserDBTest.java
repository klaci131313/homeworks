/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshopdb;

import com.laszlokovacs.UserDTO;
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
    public void testGetUser() {
        Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, result.get(Calendar.YEAR) + 10);
        Date date = result.getTime();
        UserDTO userDTO = new UserDTO("klaci13", "Almafa12", "klaci13@gmail.com", date);
        UserDB userDB = new UserDB();
        userDB.registrate(userDTO);
        assertEquals(userDTO, userDB.getUser(userDTO.getUserName()));

    }

}
