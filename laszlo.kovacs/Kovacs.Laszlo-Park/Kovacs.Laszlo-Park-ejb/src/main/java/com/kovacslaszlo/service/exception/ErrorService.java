package com.kovacslaszlo.service.exception;

/**
 *
 * @author Laci
 */
public class ErrorService {

    private String errorMessage;

    public ErrorService() {
        //constructor
    }

    public ErrorService(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }   
}
