package com.kovacslaszlo.rest;

import com.kovacslaszlo.service.MobileTypeDB;
import com.kovacslaszlo.service.ShoppingCart;
import static com.kovacslaszlo.session.Session.isValidLogin;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

/**
 *
 * @author Laci
 */
@Path("/cart")
public class CartResource {

    @Inject
    private ShoppingCart cart;
    @Inject
    private MobileTypeDB mobileTypeDB;

    @POST
    @Path("/addmobile/{id}")
    public boolean addMobileToCart(@Context HttpServletRequest request, @PathParam("id") String id) {
        isValidLogin(request);
        return cart.addMobile(mobileTypeDB.getMobileTypeById(id), 1);
    }

    @POST
    @Path("/removemobile/{id}")
    public boolean removeMobileToCart(@Context HttpServletRequest request, @PathParam("id") String id) {
        isValidLogin(request);
        return cart.removeMobileById(id, 1);
    }

    @POST
    @Path("/purschesecart")
    public void purchaseCart(@Context HttpServletRequest request) {
        isValidLogin(request);
        cart.purchaseCart();
    }
}
