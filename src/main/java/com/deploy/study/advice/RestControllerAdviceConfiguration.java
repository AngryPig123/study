package com.deploy.study.advice;

import com.deploy.study.advice.exception.DeployException;
import com.deploy.study.dto.user.response.ErrorResponse;
import com.deploy.study.dto.user.response.ExceptionResponseDTO;
import com.deploy.study.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
public class RestControllerAdviceConfiguration {

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomBadRequestException.class)
    public ResponseEntity<ErrorResponse> handleException(CustomBadRequestException exc) {

        //  create a ErrorResponse
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(messageSource.getMessage(exc.getMessage(), null, Locale.KOREA));
        error.setTimeStamp(System.currentTimeMillis());
        //  return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
