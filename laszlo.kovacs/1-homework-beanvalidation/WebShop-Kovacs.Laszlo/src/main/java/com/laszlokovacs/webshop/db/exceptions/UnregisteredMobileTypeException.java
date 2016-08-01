package com.laszlokovacs.webshop.db.exceptions;

public class UnregisteredMobileTypeException extends RuntimeException {

    public UnregisteredMobileTypeException(String message) {
        super(message);
    }
}
