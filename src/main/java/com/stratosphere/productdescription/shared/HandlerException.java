package com.stratosphere.productdescription.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(HandlerException.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> invoke(Exception exception) {
        return buildGenericExceptionResponse(exception);
    }

    private ResponseEntity<?> buildGenericExceptionResponse(Exception exception) {
        ErrorResponse error = new ErrorResponse(
                exception.getMessage().substring(0, 3),
                exception.getMessage()
        );
        log.error("ERROR: " + exception.getMessage());
        return ResponseEntity.status(Integer.parseInt(error.getStatusCode())).body(error);
    }
}
