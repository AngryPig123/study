package com.deploy.study.common.enumtype;

import org.springframework.http.HttpStatus;

public enum Http4xxEnumClass {

    BAD_REQUEST(HttpStatus.BAD_REQUEST),
    NOT_FOUND(HttpStatus.NOT_FOUND);

    private final HttpStatus status;

    public HttpStatus getStatus() {
        return this.status;
    }

    Http4xxEnumClass(HttpStatus status) {
        this.status = status;
    }

}
