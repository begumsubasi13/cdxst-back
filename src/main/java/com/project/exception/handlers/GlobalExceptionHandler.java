package com.project.exception.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = "Invalid parameter value: " + ex.getName() + " should be of type " + ex.getRequiredType().getSimpleName();
        return ResponseEntity.badRequest().body(message);
    }
	
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex) {
        String message = "Required parameter '" + ex.getParameterName() + "' is missing";
        return ResponseEntity.badRequest().body(message);
    }

}
