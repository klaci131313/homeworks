/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshopdb;

import com.laszlokovacs.Color;
import com.laszlokovacs.Currency;
import com.laszlokovacs.Manufacturer;
import com.laszlokovacs.MobileType;
import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laci
 */
public class MobileTypeDBTest {

    MobileTypeDB mobileTypeDB = new MobileTypeDB();

    @Test
    public void testReturnMobile() {
        String uuid = UUID.randomUUID().toString();
        MobileType mobileType = new MobileType(uuid, Manufacturer.APPLE,
                "s12", 16000, Currency.EUR, Color.BLUE);
        mobileTypeDB.addNewMobileType(mobileType);
        mobileTypeDB.returnMobile(mobileType, 10);
        assertEquals(10, mobileTypeDB.getNumberOfMobile(mobileType));

    }

    @Test
    public void testAddNewMobileType() {
        String uuid = UUID.randomUUID().toString();
        MobileType mobileType = new MobileType(uuid, Manufacturer.APPLE,
                "s12", 16000, Currency.EUR, Color.BLUE);
        mobileTypeDB.addNewMobileType(mobileType);
        assertEquals(0, mobileTypeDB.getNumberOfMobile(mobileType));

    }

    @Test
    public void testReserveMobileFailed() {
        String uuid = UUID.randomUUID().toString();
        MobileType mobileType = new MobileType(uuid, Manufacturer.APPLE,
                "s12", 16000, Currency.EUR, Color.BLUE);
        mobileTypeDB.addNewMobileType(mobileType);

        mobileTypeDB.returnMobile(mobileType, 3);
        assertEquals(mobileTypeDB.reserveMobile(mobileType, 7), false);
    }

    @Test
    public void testReserveMobileSucces() {
        String uuid = UUID.randomUUID().toString();
        MobileType mobileType = new MobileType(uuid, Manufacturer.APPLE,
                "s12", 16000, Currency.EUR, Color.BLUE);
        mobileTypeDB.addNewMobileType(mobileType);

        mobileTypeDB.returnMobile(mobileType, 10);
        assertEquals(mobileTypeDB.reserveMobile(mobileType, 7), true);
    }
}
