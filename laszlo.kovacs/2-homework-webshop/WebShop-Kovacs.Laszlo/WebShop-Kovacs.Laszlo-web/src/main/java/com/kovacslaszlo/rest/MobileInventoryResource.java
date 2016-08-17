package com.kovacslaszlo.rest;

import com.kovacslaszlo.service.MobileTypeDB;
import static com.kovacslaszlo.session.Session.isValidLogin;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Laci
 */
@Path("/mobileinventory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MobileInventoryResource implements Serializable {

    @Inject
    private MobileTypeDB mobileTypeDB;
    private static final transient Logger LOGGER
            = Logger.getLogger(UserDBResource.class.getName());

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getQuantityOfMobileType(@PathParam("id") String id) {
        return mobileTypeDB.getNumberOfMobile(mobileTypeDB.getMobileTypeById(id));
    }

    @PUT
    @Path("/addmobile/{id}/{piece}")
    public void addMobile(@Context HttpServletRequest request,
            @PathParam("id") String id, @PathParam("piece") int piece) {
        isValidLogin(request);
        mobileTypeDB.returnMobile(mobileTypeDB.getMobileTypeById(id), piece);
        LOGGER.log(Level.INFO, "Added mobiles!");
    }

    @PUT
    @Path("/removeMobile/{id}/{piece}")
    @Consumes(MediaType.TEXT_PLAIN)
    public boolean removeMobile(@Context HttpServletRequest request,
            @PathParam("id") String id, @PathParam("piece") int piece) {
        isValidLogin(request);
        return mobileTypeDB.returnMobile(mobileTypeDB.getMobileTypeById(id), -piece);
    }
}
