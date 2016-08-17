package com.kovacslaszlo.exceptions;

/**
 *
 * @author Laci
 */
public class NotValidLoginException extends RuntimeException {

    public NotValidLoginException(String message) {
        super(message);
    }
}
