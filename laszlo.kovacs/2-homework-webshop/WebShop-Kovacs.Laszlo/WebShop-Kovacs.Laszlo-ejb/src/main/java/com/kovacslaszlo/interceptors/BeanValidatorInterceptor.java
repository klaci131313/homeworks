package com.kovacslaszlo.interceptors;

import com.kovacslaszlo.annotations.DTOQualifier;
import com.kovacslaszlo.exceptions.InterceptorException;
import com.kovacslaszlo.exceptions.NotValidParametersException;
import java.util.Set;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author Laci
 */
@Interceptor
@ValidatorInterceptorBinding
public class BeanValidatorInterceptor {

    @Inject
    private Validator validator;

    @AroundInvoke
    public Object validatorMethod(InvocationContext ic) {
        validateObject(ic.getParameters());
        try {
            return ic.proceed();
        } catch (Exception e) {
            throw new InterceptorException(e);
        }
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
