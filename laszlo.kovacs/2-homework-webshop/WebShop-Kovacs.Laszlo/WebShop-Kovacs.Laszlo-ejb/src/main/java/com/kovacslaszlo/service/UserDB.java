package com.kovacslaszlo.service;

import com.kovacslaszlo.beans.UserDTO;
import com.kovacslaszlo.exceptions.UsernameAlreadyExistsException;
import com.kovacslaszlo.interceptors.ValidatorInterceptorBinding;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;

/**
 *
 * @author Laci
 */
@Singleton
public class UserDB implements Serializable {

    private Map<String, UserDTO> userList = new HashMap();

    @ValidatorInterceptorBinding
    public UserDTO registrate(UserDTO userDTO) {
        String username = userDTO.getUserName();
        if (userList.containsKey(username)) {
            throw new UsernameAlreadyExistsException("Username already exists: "
                    + userDTO.getUserName());
        }
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

    public List<UserDTO> getUserList() {
        List<UserDTO> users = new ArrayList();
        for (Map.Entry<String, UserDTO> entry : userList.entrySet()) {
            users.add(entry.getValue());
        }
        return users;
    }

    @ValidatorInterceptorBinding
    public boolean removeUserDTO(UserDTO user) {
        if (userList.containsKey(user)) {
            userList.remove(user.getUserName());
            return true;
        } else {
            return false;
        }
    }

    public boolean removeUserDTOById(String username) {
        if (userList.containsKey(username)) {
            userList.remove(username);
            return true;
        } else {
            return false;
        }
    }
}
