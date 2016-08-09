package com.laszlokovacs.webshop.db;

import com.laszlokovacs.webshop.beans.MobileType;
import com.laszlokovacs.webshop.db.exceptions.UnregisteredMobileTypeException;
import com.laszlokovacs.webshop.interceptors.ValidatorInterceptor;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Laci
 */
@ValidatorInterceptor
public class MobileTypeDB {

    private final Map<MobileType, Integer> mobileList = new HashMap<>();

    public MobileType addNewMobileType(MobileType mobileType) {
        mobileList.put(mobileType, 0);
        return mobileType;
    }

    public boolean reserveMobile(MobileType mobileType, int reserve) {
        if (mobileList.get(mobileType) == null) {
            throw new UnregisteredMobileTypeException("Unregistered mobiletype:"
                    + mobileType.getType());
        }

        if (mobileList.get(mobileType) < reserve) {
            return false;
        } else {
            int remainder = mobileList.get(mobileType) - reserve;
            mobileList.put(mobileType, remainder);
            return true;
        }
    }

    public int getNumberOfMobile(MobileType mobileType) {
        if (mobileList.get(mobileType) == null) {
            throw new UnregisteredMobileTypeException("Unregistered mobiletype:"
                    + mobileType.getType());
        }
        return mobileList.get(mobileType);
    }

    public boolean returnMobile(MobileType mobileType, int piece) {
        if (mobileList.get(mobileType) == null) {
            return false;
        } else {
            mobileList.put(mobileType, mobileList.get(mobileType) + piece);
            return true;
        }
    }
}
