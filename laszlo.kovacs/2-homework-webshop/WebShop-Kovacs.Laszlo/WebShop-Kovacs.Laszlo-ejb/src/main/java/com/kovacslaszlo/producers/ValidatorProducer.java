package com.kovacslaszlo.producers;

import com.kovacslaszlo.annotations.ValidatorQualifier;
import javax.enterprise.inject.Produces;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Laci
 */
public class ValidatorProducer {

    @Produces @ValidatorQualifier
    public Validator produceValidator() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        return vf.getValidator();
    }
}
