package com.kovacslaszlo.exceptions;

/**
 *
 * @author Laci
 */
public class InterceptorException extends RuntimeException {

    public InterceptorException(Exception e) {
        super(e);
    }
}
