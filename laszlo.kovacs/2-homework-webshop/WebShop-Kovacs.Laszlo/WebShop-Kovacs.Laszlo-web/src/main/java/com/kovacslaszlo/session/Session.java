package com.kovacslaszlo.session;

import com.kovacslaszlo.beans.UserDTO;
import com.kovacslaszlo.exceptions.NotValidLoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Laci
 */
public abstract class Session {

    private Session() {
        //private constructor
    }

    public static boolean isValidAdminLogin(HttpServletRequest request) {
        UserDTO userDTO = isValidLogin(request);
        return userDTO.isAdmin();
    }

    public static UserDTO isValidLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object object = session.getAttribute("user");
        if (object != null && object instanceof UserDTO) {
            return (UserDTO) object;
        } else {
            session.invalidate();
            throw new NotValidLoginException("Not valid login");
        }
    }
}
