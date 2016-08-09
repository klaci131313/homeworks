package service;

import com.laszlokovacs.webshop.beans.MobileType;
import com.laszlokovacs.webshop.db.MobileTypeDB;
import com.laszlokovacs.webshop.main.Main;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laci
 */
public class ShoppingCart {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    private final Map<MobileType, Integer> cart = new HashMap<>();
    private final MobileTypeDB mobileTypeDB = new MobileTypeDB();

    public boolean addMobile(MobileType id, int quantity) {
        if (mobileTypeDB.reserveMobile(id, quantity)) {
            cart.put(id, quantity+cart.get(id));
            return true;
        } else {
            return false;
        }
    }

    public boolean removeMobile(MobileType id, int quantity) {

        if (cart.get(id) > quantity) {
            mobileTypeDB.returnMobile(id, quantity);
            int newQuantity = cart.get(id) - quantity;
            cart.put(id, newQuantity);
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
}
