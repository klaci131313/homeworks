package com.laszlokovacs.webshop.db;

import com.laszlokovacs.webshop.db.exceptions.UsernameAlreadyExistsException;
import com.laszlokovacs.webshop.beans.UserDTO;
import com.laszlokovacs.webshop.interceptors.ValidatorInterceptor;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Laci
 */
@ValidatorInterceptor
public class UserDB {

    private final Map<String, UserDTO> userList = new HashMap<>();

    public UserDTO registrate(UserDTO userDTO) {
        String username = userDTO.getUserName();
        if (userList.get(username) != null) {
            throw new UsernameAlreadyExistsException("Username already exists: "
                    + userDTO.getUserName());
        }
        Date date = new Date();
        userDTO.setRegistrationDate(date);
        userList.put(username, userDTO);
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
