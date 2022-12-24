package com.deploy.study.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

public class ExceptionResponseDTO {
    @JsonProperty("error_type")
    private String errorType;

    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("url")
    private String url;

    @Builder
    public ExceptionResponseDTO(String errorCode, String errorMessage, String url) {
//        this.errorType = errorType;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.url = url;
    }

}
