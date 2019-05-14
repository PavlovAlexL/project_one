package com.palex.practice.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(
            value = {Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex) {
        return new ResponseEntity<Object>(new ErrorView(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
