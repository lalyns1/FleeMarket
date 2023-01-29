package com.lalyns.fleemarket.util.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefualtExceptionHandlers {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        ExceptionDto res = new ExceptionDto(e.getMessage(), e.getStackTrace());
        return ResponseEntity.badRequest().body(res);
    }
    
}
