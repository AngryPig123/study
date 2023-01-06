package com.deploy.study.advice;


public class CustomBadRequestException extends RuntimeException {

    public CustomBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomBadRequestException(String message) {
        super(message);
    }

    public CustomBadRequestException(Throwable cause) {
        super(cause);
    }

}
