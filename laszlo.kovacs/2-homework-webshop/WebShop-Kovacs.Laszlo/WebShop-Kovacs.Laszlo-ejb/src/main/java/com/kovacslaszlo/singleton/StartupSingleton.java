package com.kovacslaszlo.singleton;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kovacslaszlo.beans.MobileType;
import com.kovacslaszlo.beans.UserDTO;
import com.kovacslaszlo.exceptions.StartUpException;
import com.kovacslaszlo.service.MobileTypeDB;
import com.kovacslaszlo.service.UserDB;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Laci
 */
@Singleton
@Startup
public class StartupSingleton {

    @Inject
    private MobileTypeDB mobileTypeDB;
    @Inject
    private UserDB userDB;

    @PostConstruct
    public void init() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<MobileType> mobileTypes
                    = objectMapper.readValue(StartupSingleton.class
                            .getClassLoader().getResource("JsonMobileType.json"),
                            new TypeReference<List<MobileType>>() {
                    });

            List<UserDTO> userDTOs
                    = objectMapper.readValue(StartupSingleton.class
                            .getClassLoader().getResource("JsonUserDTO.json"),
                            new TypeReference<List<UserDTO>>() {
                    });
            updateMobileTypeDB(mobileTypes);
            updateMobileStock(mobileTypes);
            updateUserDB(userDTOs);
        } catch (Exception e) {
            throw new StartUpException(e);
        }
    }

    private void updateMobileTypeDB(List<MobileType> mobileTypes) {
        for (MobileType mobileType : mobileTypes) {
            mobileTypeDB.addNewMobileType(mobileType);
        }
    }

    private void updateMobileStock(List<MobileType> mobileTypes) {
        for (MobileType mobileType : mobileTypes) {
            mobileTypeDB.returnMobile(mobileType, 10);
        }
    }

    private void updateUserDB(List<UserDTO> userDTOs) {
        for (UserDTO userDTO : userDTOs) {
            userDB.registrate(userDTO);
        }
    }
}
