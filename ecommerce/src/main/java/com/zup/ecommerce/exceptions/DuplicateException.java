package com.zup.ecommerce.exceptions;


import jakarta.persistence.EntityExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public abstract class DuplicateException extends EntityExistsException {
    public DuplicateException(String message){
        super(message);
    }
}
