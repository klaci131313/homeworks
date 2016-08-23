package com.kovacslaszlo.resource;

import com.kovacslaszlo.dto.MachineDTO;
import com.kovacslaszlo.entity.Guest;
import com.kovacslaszlo.entity.Machine;
import com.kovacslaszlo.service.MachineService;
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
@Path("/machines")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MachineResource {

    @Inject
    private MachineService machineService;

    @GET
    @Path("/{machineId}")
    public Response getMachine(@PathParam("machineId") Long machineId) {
        Machine machine = machineService.getMachine(machineId);
        return Response.ok(machine).build();
    }

    @GET
    @Path("/{machineId}/guests")
    public Response getGuest(@PathParam("machineId") Long machineId) {
        Collection<Guest> guests = machineService.getGuests(machineId);
        return Response.ok(guests).build();
    }

    @POST
    public Response createMachine(MachineDTO machineDTO) {
        Machine machine = machineService.createMachine(machineDTO);
        return Response.ok(machine).build();
    }

    @PUT
    @Path("/{parkId}")
    public Response addMachineToPark(MachineDTO machineDTO, @PathParam("parkId") Long parkId) {
        Machine machine = machineService.addToPark(machineDTO, parkId);
        return Response.ok(machine).build();
    }

    @PUT
    @Path("/{parkId}/removemachine/{machineId}")
    public Response removeMachineToPark(@PathParam("machineId") Long machineId, @PathParam("parkId") Long parkId) {
        Machine machine = machineService.removeToPark(machineId, parkId);
        return Response.ok(machine).build();
    }

    @DELETE
    @Path("/{machineId}")
    public Response deleteMachine(@PathParam("machineId") Long machineId) {
        Machine machine = machineService.deleteMachine(machineId);
        return Response.ok(machine).build();
    }
}
