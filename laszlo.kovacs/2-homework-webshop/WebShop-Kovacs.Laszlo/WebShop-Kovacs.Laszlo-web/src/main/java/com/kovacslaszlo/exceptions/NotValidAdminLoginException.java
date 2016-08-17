package com.kovacslaszlo.exceptions;

/**
 *
 * @author Laci
 */
public class NotValidAdminLoginException extends RuntimeException {

    public NotValidAdminLoginException(String message) {
        super(message);
    }
}
