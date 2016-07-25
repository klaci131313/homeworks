/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshopdb;

import com.laszlokovacs.MobileType;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import myexceptions.UnregisteredMobileTypeException;

/**
 *
 * @author Laci
 */
public class MobileTypeDB {

    private Map<MobileType, Integer> mobileList = new HashMap<>();

    public void setMobileList(Map<MobileType, Integer> mobileList) {
        this.mobileList = mobileList;
    }

    public MobileType addNewMobileType(MobileType mobileType) {

        mobileList.put(mobileType, 0);
        return mobileType;
    }

    public boolean reserveMobile(MobileType mobileType, int reserve) {

        try {
            if (mobileList.get(mobileType) == null) {
                throw new UnregisteredMobileTypeException();
            } else if (mobileList.get(mobileType) < reserve) {
                return false;
            } else {
                int remainder = mobileList.get(mobileType) - reserve;
                mobileList.put(mobileType, remainder);
                return true;
            }
        } catch (UnregisteredMobileTypeException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public int getNumberOfMobile(MobileType mobileType) {
        try {
            if (mobileList.get(mobileType) == null) {
                throw new UnregisteredMobileTypeException();
            } else {
                return mobileList.get(mobileType);
            }

        } catch (UnregisteredMobileTypeException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, e);

            return -1;
        }

    }

    public boolean returnMobile(MobileType mobileType, int piece) {
        try {
            if (mobileList.get(mobileType) == null) {
                throw new UnregisteredMobileTypeException();
            } else {
                mobileList.put(mobileType, mobileList.get(mobileType) + piece);
                return true;

            }
        } catch (UnregisteredMobileTypeException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public Map<MobileType, Integer> getMobileList() {
        return mobileList;
    }

}
