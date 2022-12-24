package com.deploy.study.advice;

import com.deploy.study.advice.exception.DeployException;
import com.deploy.study.dto.ExceptionResponseDTO;
import com.deploy.study.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
public class DeployExceptionHandler {

    private final MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = DeployException.class)   // *
    public ResponseDTO<ExceptionResponseDTO> ExceptionHandler(DeployException e) {

        ExceptionResponseDTO exceptionResponse =
                ExceptionResponseDTO
                        .builder()
                        .errorCode(e.getCode())
                        .errorMessage(messageSource.getMessage(e.getMessage(), null, Locale.KOREA))
                        .url(e.getPath())
                        .build();

        return new ResponseDTO<>(e.getCode(), exceptionResponse);
    }

}
