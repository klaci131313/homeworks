package com.kovacslaszlo.exceptions;

import com.kovacslaszlo.service.ShoppingCart;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Laci
 */
@Provider
public class NotValidLoginExceptionMapper implements ExceptionMapper<NotValidLoginException> {

    private static final Logger LOGGER
            = Logger.getLogger(ShoppingCart.class.getName());

    @Override
    public Response toResponse(NotValidLoginException exception) {
        LOGGER.log(Level.WARNING, "Login was not made by an admin!");
        return Response.status(Status.UNAUTHORIZED)
                .entity(new ErrorDTO(exception.getMessage()))
                .type(MediaType.APPLICATION_JSON).build();
    }
}
