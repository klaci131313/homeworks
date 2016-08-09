package com.laszlokovacs.webshop.interceptors;

import com.laszlokovacs.webshop.db.exceptions.NotValidParametersException;
import java.util.Set;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import com.laszlokovacs.webshop.annotations.DTOQualifier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 *
 * @author Laci
 */
@Interceptor
@ValidatorInterceptor
public class BeanValidatorInterceptor {

    @Inject
    @Default
    private Validator validator;

    @AroundInvoke
    public Object validatorMethod(InvocationContext ic) {
        validateObject(ic.getParameters());

        try {
            return ic.proceed();
        } catch (Exception e) {
            Logger.getLogger(BeanValidatorInterceptor.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }

    private void validateObject(Object[] objects) {
        for (Object object : objects) {
            if (object.getClass().isAnnotationPresent(DTOQualifier.class)) {
                Set<ConstraintViolation<Object>> violations
                        = validator.validate(object);
                if (!violations.isEmpty()) {
                    throw new NotValidParametersException("Not valid parameters");
                }
            }
        }
    }
}
