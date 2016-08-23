package com.kovacslaszlo.service.exceptionmapper;

import com.kovacslaszlo.service.exception.ErrorService;
import com.kovacslaszlo.service.exception.NotEnoughAreaException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Laci
 */
@Provider
public class NotEnoughAreaExceptionMapper implements ExceptionMapper<NotEnoughAreaException> {

    @Override
    public Response toResponse(NotEnoughAreaException exception) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ErrorService(exception.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
