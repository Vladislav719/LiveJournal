package com.github.gazizovrim.exceptions;

/**
 * Created by vladislav on 10.05.2015.
 */
public class GeneralException extends RuntimeException {

    private String errorCode = "Unknown_Exception";

    public GeneralException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
