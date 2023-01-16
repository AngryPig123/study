package com.deploy.study.advice;

import com.deploy.study.dto.user.response.ErrorResponse;
import com.deploy.study.exception.CustomBadRequestException;
import com.deploy.study.exception.CustomNotFoundException;
import com.deploy.study.repository.exception.ErrorResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static com.deploy.study.common.enumtype.Http4xxEnumClass.BAD_REQUEST;
import static com.deploy.study.common.enumtype.Http4xxEnumClass.NOT_FOUND;

@RestControllerAdvice
@RequiredArgsConstructor
public class RestControllerAdviceConfiguration {

    private final MessageSource messageSource;
    private final HttpServletRequest request;
    private final ErrorResponseRepository repository;

    @ExceptionHandler(CustomBadRequestException.class)
    public ResponseEntity<ErrorResponse> handleException(CustomBadRequestException exc) {
        //  create a ErrorResponse
        ErrorResponse error = ErrorResponse.builder()
                .status(BAD_REQUEST.getStatus().value())
                .message(messageSource.getMessage(exc.getMessage(), null, Locale.KOREA))
                .timeStamp(System.currentTimeMillis())
                .urlPath(request.getRequestURI())
                .build();
        repository.save(error.toEntity());
        //  return ResponseEntity
        return new ResponseEntity<>(error, BAD_REQUEST.getStatus());
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(CustomNotFoundException exc) {
        //  create a ErrorResponse
        ErrorResponse error = ErrorResponse.builder()
                .status(NOT_FOUND.getStatus().value())
                .message(messageSource.getMessage(exc.getMessage(), null, Locale.KOREA))
                .timeStamp(System.currentTimeMillis())
                .urlPath(request.getRequestURI())
                .build();

        repository.save(error.toEntity());
        //  return ResponseEntity
        return new ResponseEntity<>(error, NOT_FOUND.getStatus());
    }

}
