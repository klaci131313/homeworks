package com.laszlokovacs.webshop.db;

import com.laszlokovacs.webshop.beans.Color;
import com.laszlokovacs.webshop.beans.Currency;
import com.laszlokovacs.webshop.beans.Manufacturer;
import com.laszlokovacs.webshop.beans.MobileType;
import com.laszlokovacs.webshop.db.exceptions.UnregisteredMobileTypeException;
import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laci
 */
public class MobileTypeDBTest {

    private final MobileTypeDB mobileTypeDB = new MobileTypeDB();

    @Test
    public void testReturnMobile() {
        String uuid = UUID.randomUUID().toString();
        MobileType mobileType = new MobileType(uuid, Manufacturer.APPLE,
                "s12", 16000, Currency.EUR, Color.WHITE);
        mobileTypeDB.addNewMobileType(mobileType);
        mobileTypeDB.returnMobile(mobileType, 10);

        assertEquals(10, mobileTypeDB.getNumberOfMobile(mobileType));
    }

    @Test
    public void testAddNewMobileType() {
        String uuid = UUID.randomUUID().toString();
        MobileType mobileType = new MobileType(uuid, Manufacturer.APPLE,
                "s12", 16000, Currency.EUR, Color.WHITE);
        mobileTypeDB.addNewMobileType(mobileType);

        assertEquals(0, mobileTypeDB.getNumberOfMobile(mobileType));
    }

    @Test
    public void testReserveMobileFailed() {
        String uuid = UUID.randomUUID().toString();
        MobileType mobileType = new MobileType(uuid, Manufacturer.APPLE,
                "s12", 16000, Currency.EUR, Color.WHITE);
        mobileTypeDB.addNewMobileType(mobileType);

        mobileTypeDB.returnMobile(mobileType, 3);
        assertEquals(false, mobileTypeDB.reserveMobile(mobileType, 7));
    }

    @Test
    public void testReserveMobileSucces() {
        String uuid = UUID.randomUUID().toString();
        MobileType mobileType = new MobileType(uuid, Manufacturer.APPLE,
                "s12", 16000, Currency.EUR, Color.WHITE);
        mobileTypeDB.addNewMobileType(mobileType);

        mobileTypeDB.returnMobile(mobileType, 10);
        assertEquals(true, mobileTypeDB.reserveMobile(mobileType, 7));
    }

    @Test(expected=UnregisteredMobileTypeException.class)
    public void testReserveMobileOutOfStock() {
        String uuid = UUID.randomUUID().toString();
        MobileType mobileType = new MobileType(uuid, Manufacturer.APPLE,
                "s12", 16000, Currency.EUR, Color.WHITE);

        mobileTypeDB.reserveMobile(mobileType, 7);
    }
}
