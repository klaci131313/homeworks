package com.kovacslaszlo.resource;

import com.kovacslaszlo.dto.ParkDTO;
import com.kovacslaszlo.entity.Guest;
import com.kovacslaszlo.entity.Machine;
import com.kovacslaszlo.entity.Park;
import com.kovacslaszlo.service.ParkService;
import java.util.Collection;
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
@Path("/park")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ParkResource {

    @Inject
    private ParkService parkService;

    @GET
    @Path("/{parkId}")
    public Response getPark(@PathParam("parkId") Long parkId) {
        Park park = parkService.getPark(parkId);
        return Response.ok(park).build();
    }

    @GET
    @Path("/{parkId}/guests")
    public Response getAllGuests(@PathParam("parkId") Long parkId) {
        Collection<Guest> guestList = parkService.getAllGuest(parkId);
        return Response.ok(guestList).build();
    }

    @GET
    @Path("/{parkId}/guests/active")
    public Response getActiveGuests(@PathParam("parkId") Long parkId) {
        Collection<Guest> guestList = parkService.getActiveGuest(parkId);
        return Response.ok(guestList).build();
    }

    @GET
    @Path("/{parkId}/machines")
    public Response getAllMachines(@PathParam("parkId") Long parkId) {
        Collection<Machine> machineList = parkService.getAllMachine(parkId);
        return Response.ok(machineList).build();
    }

    @GET
    @Path("/{parkId}/machines/active")
    public Response getActiveMachines(@PathParam("parkId") Long parkId) {
        Collection<Machine> machineList = parkService.getActiveMachine(parkId);
        return Response.ok(machineList).build();
    }
    
    @POST
    public Response createPark(ParkDTO parkDTO) {
        Park park = parkService.createPark(parkDTO);
        return Response.ok(park).build();
    }

    @PUT
    @Path("/{parkId}")
    public Response updatePark(@PathParam("parkId") Long parkId, ParkDTO parkDTO) {
        Park park = parkService.updatePark(parkDTO, parkId);
        return Response.ok(park).build();
    }

    @DELETE
    @Path("/{parkId}")
    public Response deletePark(@PathParam("parkId") Long parkId) {
        Park park = parkService.getPark(parkId);
        parkService.deletePark(parkId);
        return Response.ok(park).build();
    }

}
