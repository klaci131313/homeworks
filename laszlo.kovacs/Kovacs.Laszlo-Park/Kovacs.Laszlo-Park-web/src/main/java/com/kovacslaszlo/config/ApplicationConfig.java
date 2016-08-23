package com.kovacslaszlo.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Laci
 */
@javax.ws.rs.ApplicationPath("/")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.kovacslaszlo.resource.GuestBookResource.class);
        resources.add(com.kovacslaszlo.resource.GuestResource.class);
        resources.add(com.kovacslaszlo.resource.MachineResource.class);
        resources.add(com.kovacslaszlo.resource.ParkResource.class);
        resources.add(com.kovacslaszlo.service.exceptionmapper.GeneralExceptionMapper.class);
        resources.add(com.kovacslaszlo.service.exceptionmapper.GuestIsAlreadyOnMachineExceptionMapper.class);
        resources.add(com.kovacslaszlo.service.exceptionmapper.GuestIsNotOnMachineExceptionMapper.class);
        resources.add(com.kovacslaszlo.service.exceptionmapper.MachineIsFullExceptionMapper.class);
        resources.add(com.kovacslaszlo.service.exceptionmapper.NotEmptyMachineExceptionMapper.class);
        resources.add(com.kovacslaszlo.service.exceptionmapper.NotEnoughAreaExceptionMapper.class);
        resources.add(com.kovacslaszlo.service.exceptionmapper.NotEnoughCapitalExceptionMapper.class);
        resources.add(com.kovacslaszlo.service.exceptionmapper.NotInParkExceptionMapper.class);
        resources.add(com.kovacslaszlo.service.exceptionmapper.TooYoungGuestExceptionMapper.class);
    }
}
