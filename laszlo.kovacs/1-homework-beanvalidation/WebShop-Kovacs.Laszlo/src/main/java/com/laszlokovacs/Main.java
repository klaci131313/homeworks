/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laszlokovacs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import webshopdb.MobileTypeDB;
import webshopdb.UserDB;

/**
 *
 * @author Laci
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    private static final MobileTypeDB MOBILE_TYPE_DB = new MobileTypeDB();
    private static final UserDB USERDB = new UserDB();

    private Main() {

    }

    public static void main(String[] args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        String mobileTypesJsonString = Resources.toString(
                Resources.getResource("JsonMobileType.json"), Charsets.UTF_8);
        String userDTOsJsonString = Resources.toString(
                Resources.getResource("JsonUserDTO.json"), Charsets.UTF_8);

        List<MobileType> mobileTypes = Arrays.asList(
                objectMapper.readValue(mobileTypesJsonString, MobileType[].class));
        List<UserDTO> userDTOs = Arrays.asList(
                objectMapper.readValue(userDTOsJsonString, UserDTO[].class));

        updateMobileTypeDB(mobileTypes);
        updateMobileStock(mobileTypes);
        updateUserDB(userDTOs);

        LOG.log(Level.INFO, "{0}", MOBILE_TYPE_DB.toString());
        LOG.log(Level.INFO, "{0}", USERDB.toString());

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
