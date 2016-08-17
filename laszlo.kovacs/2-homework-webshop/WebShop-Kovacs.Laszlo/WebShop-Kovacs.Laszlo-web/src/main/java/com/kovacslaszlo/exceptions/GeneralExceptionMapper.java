package com.kovacslaszlo.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Laci
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable throwable) {
        Logger.getLogger(GeneralExceptionMapper.class.getName())
                .log(Level.SEVERE, throwable.getMessage(), throwable);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorDTO(throwable.getMessage() + " - " + throwable.getCause()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
