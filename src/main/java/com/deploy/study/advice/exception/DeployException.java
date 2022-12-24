package com.deploy.study.advice.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

public class DeployException extends Exception {

    static final long serialVersionUID = -3430979530062705647L;
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    private final String path;

    @Builder
    public DeployException(HttpStatus httpStatus, String code, String message, String path) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.path = path;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

}
