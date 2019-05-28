package com.palex.practice.Error;

import com.palex.practice.view.ErrorView;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Logger;

@RestControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = Logger.getLogger("AllException logger");

    @ExceptionHandler(
            value = {Exception.class})
    public ErrorView handleAll(Exception ex) {
        logger.info(ex.getMessage());
        return new ErrorView();
    }
}