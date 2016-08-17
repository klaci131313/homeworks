package com.kovacslaszlo.service;

import com.kovacslaszlo.beans.Color;
import com.kovacslaszlo.beans.Currency;
import com.kovacslaszlo.beans.Manufacturer;
import com.kovacslaszlo.beans.MobileType;
import com.kovacslaszlo.exceptions.UnregisteredMobileTypeException;
import java.util.UUID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

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

        assertTrue(10 == mobileTypeDB.getNumberOfMobile(mobileType));
    }

    @Test
    public void testAddNewMobileType() {
        String uuid = UUID.randomUUID().toString();
        MobileType mobileType = new MobileType(uuid, Manufacturer.APPLE,
                "s12", 16000, Currency.EUR, Color.WHITE);
        mobileTypeDB.addNewMobileType(mobileType);

        assertTrue(0 == mobileTypeDB.getNumberOfMobile(mobileType));
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

    @Test(expected = UnregisteredMobileTypeException.class)
    public void testReserveMobileOutOfStock() {
        String uuid = UUID.randomUUID().toString();
        MobileType mobileType = new MobileType(uuid, Manufacturer.APPLE,
                "s12", 16000, Currency.EUR, Color.WHITE);

        mobileTypeDB.reserveMobile(mobileType, 7);
    }
}
