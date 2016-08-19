package com.kovacslaszlo.config;

import com.kovacslaszlo.exceptions.GeneralExceptionMapper;
import com.kovacslaszlo.exceptions.NotValidAdminLoginExceptionMapper;
import com.kovacslaszlo.exceptions.NotValidLoginExceptionMapper;
import com.kovacslaszlo.rest.CartResource;
import com.kovacslaszlo.rest.MobileInventoryResource;
import com.kovacslaszlo.rest.MobileTypeResource;
import com.kovacslaszlo.rest.UserDBResource;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


/**
 *
 * @author Laci
 */
@ApplicationPath("/")
public class ApplicationConfig extends Application {

    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(CartResource.class);
        c.add(UserDBResource.class);
        c.add(MobileInventoryResource.class);
        c.add(MobileTypeResource.class);
        c.add(GeneralExceptionMapper.class);
        c.add(NotValidAdminLoginExceptionMapper.class);
        c.add(NotValidLoginExceptionMapper.class);
       
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
