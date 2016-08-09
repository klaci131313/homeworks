package com.laszlokovacs.webshop.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import java.util.Arrays;
import java.util.List;
import com.laszlokovacs.webshop.db.MobileTypeDB;
import com.laszlokovacs.webshop.db.UserDB;
import com.laszlokovacs.webshop.beans.MobileType;
import com.laszlokovacs.webshop.beans.UserDTO;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author Laci
 */
public class Main {

    private static final Weld WELD = new Weld();
    private static final WeldContainer CONTAINER = WELD.initialize();
    private static final MobileTypeDB MOBILE_TYPE_DB = CONTAINER.instance().select(MobileTypeDB.class).get();
    private static final UserDB USERDB = CONTAINER.instance().select(UserDB.class).get();

    private Main() {
        //constructor
    }

    public static void main(String[] args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        List<MobileType> mobileTypes = Arrays.asList(
                objectMapper.readValue(Resources.getResource("JsonMobileType.json"),
                        MobileType[].class));
        List<UserDTO> userDTOs = Arrays.asList(
                objectMapper.readValue(Resources.getResource("JsonUserDTO.json"),
                        UserDTO[].class));

        updateMobileTypeDB(mobileTypes);
        updateMobileStock(mobileTypes);
        updateUserDB(userDTOs);

        WELD.shutdown();
    }

    private static void updateMobileTypeDB(List<MobileType> mobileTypes) {
        for (MobileType mobileType : mobileTypes) {
            MOBILE_TYPE_DB.addNewMobileType(mobileType);
        }
    }

    private static void updateMobileStock(List<MobileType> mobileTypes) {
        for (MobileType mobileType : mobileTypes) {
            MOBILE_TYPE_DB.returnMobile(mobileType, 10);
        }
    }

    private static void updateUserDB(List<UserDTO> userDTOs) {
        for (UserDTO userDTO : userDTOs) {
            USERDB.registrate(userDTO);
        }
    }
}
