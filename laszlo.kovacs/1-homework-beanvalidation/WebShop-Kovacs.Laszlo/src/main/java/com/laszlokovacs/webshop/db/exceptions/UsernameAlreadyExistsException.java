package com.laszlokovacs.webshop.db.exceptions;

/**
 *
 * @author Laci
 */
public class UsernameAlreadyExistsException extends RuntimeException {

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
