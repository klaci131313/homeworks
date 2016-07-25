/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshopdb;

import myexceptions.UsernameAlreadyExistsException;
import com.laszlokovacs.UserDTO;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laci
 */
public class UserDB {

    private final Map<String, UserDTO> userList = new HashMap<>();

    public UserDTO registrate(UserDTO userDTO) {
        String username = userDTO.getUserName();
        try {
            if (userList.get(username) != null) {
                throw new UsernameAlreadyExistsException();
            }
            Date date = new Date();
            userDTO.setRegistrationDate(date);
            userList.put(username, userDTO);
            return userDTO;

        } catch (UsernameAlreadyExistsException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, e);
        }
        return userDTO;

    }

    public boolean authenticate(String username, String password) {
        if (userList.get(username) == null) {
            return false;
        } else {
            return password.equals(userList.get(username).getPassword());
        }

    }

    public UserDTO getUser(String username) {
        return userList.get(username);
    }

}
