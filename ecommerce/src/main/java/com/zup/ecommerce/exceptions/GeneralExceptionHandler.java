package com.zup.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
    @ExceptionHandler (DuplicateException.class)
    public ResponseEntity<String> handleDuplicateException(DuplicateException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundException exception) {
        Map<String, String> error = new HashMap<>();
        error.put("O CPF digitado não foi encontrado.", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler (InvalidException.class)
    public ResponseEntity<String> handleInvalidException(InvalidException expception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(expception.getMessage());
    }
}
