package com.kovacslaszlo.resource;

import com.kovacslaszlo.dto.Description;
import com.kovacslaszlo.entity.GuestBook;
import com.kovacslaszlo.service.GuestBookService;
import com.kovacslaszlo.service.GuestService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Laci
 */
@Path("/guestbook")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GuestBookResource {

    @Inject
    private GuestService guestService;
    @Inject
    private GuestBookService guestBookService;

    @GET
    @Path("/{guestBookId}")
    public Response getGuestBook(@PathParam("guestBookId") Long guestBookId) {
        GuestBook guestBook = guestBookService.getGuestBook(guestBookId);
        return Response.ok(guestBook).build();
    }

    @POST
    @Path("/{parkId}")
    public Response createGuestBook(@PathParam("parkId") Long parkId) {
        GuestBook guestBook = guestBookService.createGuestBook(parkId);
        return Response.ok(guestBook).build();
    }

    @POST
    @Path("/{guestBookId}/{guestId}")
    public Response addDescription(@PathParam("guestBookId") Long guestBookId,
            @PathParam("guestId") Long guestId, Description description) {
        GuestBook guestBook = guestBookService.addDescription(guestId, guestBookId, description.getText());
        return Response.ok(guestBook).build();
    }

    @DELETE
    @Path("/(guestBookId)")
    public Response deleteGuestBook(@PathParam("guestBookId") Long guestBookId) {
        GuestBook guestBook = guestBookService.deleteGuestBook(guestBookId);
        return Response.ok(guestBook).build();
    }
}
