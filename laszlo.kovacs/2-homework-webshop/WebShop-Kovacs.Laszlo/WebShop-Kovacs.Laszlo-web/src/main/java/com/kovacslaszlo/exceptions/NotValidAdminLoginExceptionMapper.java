package com.kovacslaszlo.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Laci
 */
@Provider
public class NotValidAdminLoginExceptionMapper implements ExceptionMapper<NotValidLoginException> {

    @Override
    public Response toResponse(NotValidLoginException exception) {
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(new ErrorDTO(exception.getMessage()))
                .type(MediaType.APPLICATION_JSON).build();
    }
}
