package com.kovacslaszlo.rest;

import com.kovacslaszlo.beans.UserDTO;
import com.kovacslaszlo.exceptions.NotValidAdminLoginException;
import com.kovacslaszlo.service.UserDB;
import static com.kovacslaszlo.session.Session.isValidAdminLogin;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Laci
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserDBResource implements Serializable {

    @Inject
    private UserDB userDB;
    private static final transient Logger LOGGER
            = Logger.getLogger(UserDBResource.class.getName());

    @GET
    public Collection<UserDTO> getAllUser() {
        return userDB.getUserList();
    }

    @GET
    @Path("/{username}")
    public UserDTO getUserById(@PathParam("username") String username) {
        return userDB.getUser(username);
    }

    @POST
    @Path("/adduser")
    public void addUser(@Context HttpServletRequest request, UserDTO user) {
        if (isValidAdminLogin(request)) {
            userDB.registrate(user);
            LOGGER.log(Level.INFO, "{0} user created!", user.getUserName());
        } else {
            throw new NotValidAdminLoginException("Not admin login");
        }
    }

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean login(@Context HttpServletRequest request, UserDTO user) {
        HttpSession session = request.getSession(true);
        for (UserDTO acceptedUser : userDB.getUserList()) {
            if (acceptedUser.getUserName().equals(user.getUserName())) {
                session.setAttribute("user", user);
                return true;
            }
        }
        session.invalidate();
        return false;
    }

    @DELETE
    @Path("/removeuser/{username}")
    public void deleteUser(@Context HttpServletRequest request, @PathParam("username") String username) {
        if (isValidAdminLogin(request)) {
            userDB.removeUserDTOById(username);
            LOGGER.log(Level.INFO, "{0}user removed!", username);
        } else {
            throw new NotValidAdminLoginException("Not admin login");
        }
    }
}
