package com.kovacslaszlo.rest;

import com.kovacslaszlo.service.MobileTypeDB;
import com.kovacslaszlo.service.ShoppingCart;
import com.kovacslaszlo.util.LoginUtil;
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
    @Path("/add/{id}")
    public boolean addMobileToCart(@Context HttpServletRequest request, @PathParam("id") String id) {
        LoginUtil.isValidLogin(request);
        return cart.addMobile(mobileTypeDB.getMobileTypeById(id), 1);
    }

    @POST
    @Path("/remove/{id}")
    public boolean removeMobileToCart(@Context HttpServletRequest request, @PathParam("id") String id) {
        LoginUtil.isValidLogin(request);
        return cart.removeMobileById(id, 1);
    }

    @POST
    @Path("/purchasecart")
    public void purchaseCart(@Context HttpServletRequest request) {
        LoginUtil.isValidLogin(request);
        cart.purchaseCart();
    }
}
