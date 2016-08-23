package com.kovacslaszlo.resource;

import com.kovacslaszlo.dto.GuestDTO;
import com.kovacslaszlo.entity.Guest;
import com.kovacslaszlo.service.GuestService;
import com.kovacslaszlo.service.MachineService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Laci
 */
@Path("/guests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GuestResource {

    @Inject
    private GuestService guestService;
    @Inject
    private MachineService machineService;

    @GET
    @Path("/{guestId}")
    public Response getGuest(@PathParam("guestId") Long guestId) {
        Guest guest = guestService.getGuest(guestId);
        return Response.ok(guest).build();
    }

    @POST
    public Response createGuest(GuestDTO guestDTO) {
        Guest guest = guestService.createGuest(guestDTO);
        return Response.ok(guest).build();
    }

    @PUT
    @Path("/{guestId}/enterparkid/{parkId}")
    public Response enterParkById(@PathParam("guestId") Long guestId, @PathParam("parkId") Long parkId) {
        Guest guest = guestService.enterParkById(guestId, parkId);
        return Response.ok(guest).build();
    }

    @PUT
    @Path("/enterpark/{parkId}")
    public Response enterPark(GuestDTO guestDTO, @PathParam("parkId") Long parkId) {
        Guest guest = guestService.enterPark(guestDTO, parkId);
        return Response.ok(guest).build();
    }

    @PUT
    @Path("/{guestId}/exitpark/{parkId}")
    public Response exitPark(@PathParam("guestId") Long guestId, @PathParam("parkId") Long parkId) {
        Guest guest = guestService.exitPark(guestId, parkId);
        return Response.ok(guest).build();
    }

    @PUT
    @Path("/{guestId}/entermachine/{machineId}")
    public Response enterMachine(@PathParam("guestId") Long guestId, @PathParam("machineId") Long machineId) {
        Guest guest = guestService.enterMachine(guestId, machineId);
        return Response.ok(guest).build();
    }

    @PUT
    @Path("/{guestId}/exitmachine/{machineId}")
    public Response exitMachine(@PathParam("guestId") Long guestId, @PathParam("machineId") Long machineId) {
        Guest guest = guestService.exitMachine(guestId, machineId);
        return Response.ok(guest).build();
    }

    @DELETE
    @Path("/{guestId}")
    public Response deleteGuest(@PathParam("guestId") Long guestId) {
        Guest guest = guestService.deleteGuest(guestId);
        return Response.ok(guest).build();
    }
}
