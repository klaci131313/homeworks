package com.kovacslaszlo.service;

import com.kovacslaszlo.beans.MobileType;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.inject.Inject;

/**
 *
 * @author Laci
 */
@Stateful
public class ShoppingCart {

    private static final Logger LOG = Logger.getLogger(ShoppingCart.class.getName());
    private final Map<MobileType, Integer> cart = new HashMap<>();
    @Inject
    private MobileTypeDB mobileTypeDB;

    public boolean addMobile(MobileType mobileType, int quantity) {
        if (mobileTypeDB.reserveMobile(mobileType, quantity)) {
            if (cart.get(mobileType) != null) {
                cart.put(mobileType, quantity + cart.get(mobileType));
                return true;
            } else {
                cart.put(mobileType, quantity);
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean removeMobile(MobileType mobileType, int quantity) {
        if (cart.get(mobileType) > quantity) {
            mobileTypeDB.returnMobile(mobileType, quantity);
            int newQuantity = cart.get(mobileType) - quantity;
            cart.put(mobileType, newQuantity);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeMobileById(String id, int quantity) {
        if (cart.get(mobileTypeDB.getMobileTypeById(id)) > quantity) {
            mobileTypeDB.returnMobile(mobileTypeDB.getMobileTypeById(id), quantity);
            int newQuantity = cart.get(mobileTypeDB.getMobileTypeById(id)) - quantity;
            cart.put(mobileTypeDB.getMobileTypeById(id), newQuantity);
            return true;
        } else {
            return false;
        }
    }

    public void completeRemoveCart() {
        for (Map.Entry<MobileType, Integer> entry : cart.entrySet()) {

            mobileTypeDB.returnMobile(entry.getKey(), entry.getValue());
            cart.remove(entry.getKey());
        }
    }

    public int totalValue() {
        int totalValue = 0;
        for (Map.Entry<MobileType, Integer> entry : cart.entrySet()) {
            totalValue += entry.getKey().getPrice();
        }
        return totalValue;
    }

    public void purchaseCart() {
        int totalValue = 0;
        for (Map.Entry<MobileType, Integer> entry : cart.entrySet()) {
            totalValue += entry.getKey().getPrice();
            LOG.log(Level.INFO, "{0}", entry.getKey().getType() + " quantity: "
                    + entry.getValue());
        }
        LOG.log(Level.INFO, "{0}", "Total value: " + totalValue);
    }

    public Map<MobileType, Integer> getCart() {
        return cart;
    }

}
