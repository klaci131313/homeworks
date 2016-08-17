package com.kovacslaszlo.service;

import com.kovacslaszlo.beans.MobileType;
import com.kovacslaszlo.exceptions.UnregisteredMobileTypeException;
import com.kovacslaszlo.interceptors.ValidatorInterceptorBinding;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;

/**
 *
 * @author Laci
 */
@Singleton
public class MobileTypeDB implements Serializable {

    private Map<MobileType, Integer> mobileList = new HashMap();

    @ValidatorInterceptorBinding
    public MobileType addNewMobileType(MobileType mobileType) {
        mobileList.put(mobileType, 0);
        return mobileType;
    }

    public MobileType getMobileTypeById(String id) {
        for (Map.Entry<MobileType, Integer> entry : mobileList.entrySet()) {
            if (entry.getKey().getId().equals(id)) {
                return entry.getKey();
            }
        }
        throw new UnregisteredMobileTypeException("Not registered mobiletype");
    }

    public Collection<MobileType> getAllMobileType() {
        List<MobileType> list = new ArrayList();
        for (Map.Entry<MobileType, Integer> entry : this.mobileList.entrySet()) {
            list.add(entry.getKey());
        }
        return list;
    }

    @ValidatorInterceptorBinding
    public MobileType removeMobileType(MobileType mobileType) {
        mobileList.remove(mobileType);
        return mobileType;
    }

    public void removeMobileTypeById(String id) {
        for (Map.Entry<MobileType, Integer> entry : this.mobileList.entrySet()) {
            if (entry.getKey().getId() == id) {
                mobileList.remove(entry.getKey());
            }
        }
    }

    @ValidatorInterceptorBinding
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

    @ValidatorInterceptorBinding
    public Integer getNumberOfMobile(MobileType mobileType) {
        if (mobileList.get(mobileType) == null) {
            throw new UnregisteredMobileTypeException("Unregistered mobiletype:"
                    + mobileType.getType());
        }
        return mobileList.get(mobileType);
    }

    @ValidatorInterceptorBinding
    public boolean returnMobile(MobileType mobileType, int piece) {
        if (mobileList.get(mobileType) == null) {
            throw new UnregisteredMobileTypeException("Unregistered mobile type");
        } else {
            mobileList.put(mobileType, mobileList.get(mobileType) + piece);
            return true;
        }
    }
}
