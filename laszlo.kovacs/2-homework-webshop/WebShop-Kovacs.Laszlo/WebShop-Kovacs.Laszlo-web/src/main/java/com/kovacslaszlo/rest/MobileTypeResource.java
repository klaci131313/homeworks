package com.kovacslaszlo.rest;

import com.kovacslaszlo.beans.MobileType;
import com.kovacslaszlo.exceptions.NotValidAdminLoginException;
import com.kovacslaszlo.service.MobileTypeDB;
import static com.kovacslaszlo.session.Session.isValidAdminLogin;
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
@Path("/mobiletype")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MobileTypeResource implements Serializable {

    @Inject
    private MobileTypeDB mobileTypeDB;
    private static final transient Logger LOGGER = Logger.getLogger(MobileTypeResource.class.getName());

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
    @Path("/addMobile")
    public void addMobileType(@Context HttpServletRequest request, MobileType mobileType) {
        if (isValidAdminLogin(request)) {
            mobileTypeDB.addNewMobileType(mobileType);
            LOGGER.log(Level.INFO, "{0} type added!", mobileType.getType());
        } else {
            throw new NotValidAdminLoginException("Not admin login");
        }
    }

    @DELETE
    @Path("/remove/{id}")
    public void removeMobileTypeById(@Context HttpServletRequest request, @PathParam("id") String id) {
        if (isValidAdminLogin(request)) {
            mobileTypeDB.removeMobileTypeById(id);
            LOGGER.log(Level.INFO, "{0} type removed!", id);
        } else {
            throw new NotValidAdminLoginException("Not admin login");
        }
    }
}
