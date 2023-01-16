package com.deploy.study.exception;


public class CustomNotFoundException extends RuntimeException {

    public CustomNotFoundException(String message) {
        super(message);
    }

//    public CustomBadRequestException(String message, Throwable cause) {
//        super(message, cause);
//    }

//    public CustomBadRequestException(Throwable cause) {
//        super(cause);
//    }

}
