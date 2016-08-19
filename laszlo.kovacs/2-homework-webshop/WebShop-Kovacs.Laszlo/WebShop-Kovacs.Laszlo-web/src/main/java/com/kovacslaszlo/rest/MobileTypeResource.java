package com.kovacslaszlo.rest;

import com.kovacslaszlo.beans.MobileType;
import com.kovacslaszlo.exceptions.NotValidAdminLoginException;
import com.kovacslaszlo.service.MobileTypeDB;
import com.kovacslaszlo.util.LoginUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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
@Path("/mobiletypes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MobileTypeResource implements Serializable {

    @Inject
    private MobileTypeDB mobileTypeDB;

    private static final Logger LOGGER
            = Logger.getLogger(MobileTypeResource.class.getName());

    @GET
    public Collection<MobileType> getAllMobileType() {
        return mobileTypeDB.getAllMobileType();
    }

    @GET
    @Path("/{mobileTypeID}")
    public MobileType getMobileTypeById(@PathParam("mobileTypeID") String id) {
        return mobileTypeDB.getMobileTypeById(id);
    }

    @POST
    public void addMobileType(@Context HttpServletRequest request, MobileType mobileType) {
        if (LoginUtil.isValidAdminLogin(request)) {
            mobileTypeDB.addNewMobileType(mobileType);
            LOGGER.log(Level.INFO, "{0} type added!", mobileType.getType());
        } else {
            throw new NotValidAdminLoginException("Not admin login");
        }
    }

    @DELETE
    @Path("/{id}")
    public void removeMobileTypeById(@Context HttpServletRequest request, @PathParam("id") String id) {
        if (LoginUtil.isValidAdminLogin(request)) {
            mobileTypeDB.removeMobileTypeById(id);
            LOGGER.log(Level.INFO, "{0} type removed!", id);
        } else {
            throw new NotValidAdminLoginException("Not admin login");
        }
    }
}
