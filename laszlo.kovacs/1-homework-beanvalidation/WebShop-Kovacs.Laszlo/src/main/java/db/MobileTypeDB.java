package db;

import dto.MobileType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Laci
 */
public class MobileTypeDB {

    private Map<MobileType, Integer> mobileList = new HashMap<>();

    public MobileType addNewMobileType(MobileType mobileType) {

        mobileList.put(mobileType, 0);
        return mobileType;
    }

    public boolean reserveMobile(MobileType mobileType, int reserve) {
        if (mobileList.get(mobileType) == null || mobileList.get(mobileType) < reserve) {

            return false;

        } else {
            int remainder = mobileList.get(mobileType) - reserve;
            mobileList.put(mobileType, remainder);
            return true;
        }
    }

    public int getNumberOfMobile(MobileType mobileType) {
        if (mobileList.get(mobileType) == null) {
            return -1;
        } else {
            return mobileList.get(mobileType);
        }
    }

    public boolean returnMobile(MobileType mobileType, int piece) {
        if (mobileList.get(mobileType) == null) {
            return false;
        } else {
            mobileList.put(mobileType, mobileList.get(mobileType) + piece);
            return true;
        }
    }

    public Map<MobileType, Integer> getMobileList() {
        return mobileList;
    }
}
