package com.kovacslaszlo.config;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Laci
 */
@ApplicationPath("/")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.kovacslaszlo.exceptions.GeneralExceptionMapper.class);
        resources.add(com.kovacslaszlo.exceptions.NotValidAdminLoginExceptionMapper.class);
        resources.add(com.kovacslaszlo.exceptions.NotValidLoginExceptionMapper.class);
        resources.add(com.kovacslaszlo.rest.CartResource.class);
        resources.add(com.kovacslaszlo.rest.MobileInventoryResource.class);
        resources.add(com.kovacslaszlo.rest.MobileTypeResource.class);
        resources.add(com.kovacslaszlo.rest.UserDBResource.class);
    }
}
