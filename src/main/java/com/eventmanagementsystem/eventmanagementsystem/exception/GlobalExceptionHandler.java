package com.eventmanagementsystem.eventmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>>
    handleResourceNotFound(
            ResourceNotFoundException ex) {

        Map<String, String> error =
                new HashMap<>();

        error.put("message", ex.getMessage());

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>
    handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> error =
                new HashMap<>();

        String message =
                ex.getBindingResult()
                        .getFieldError()
                        .getDefaultMessage();

        error.put("message", message);

        return new ResponseEntity<>(
                error,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>>
    handleGenericException(
            Exception ex) {

        Map<String, String> error =
                new HashMap<>();

        error.put(
                "message",
                ex.getMessage());

        return new ResponseEntity<>(
                error,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}