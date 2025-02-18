package com.zup.ecommerce.exceptions;


import jakarta.persistence.EntityExistsException;

public abstract class DuplicateException extends EntityExistsException {
    public DuplicateException(String message){
        super(message);
    }
}
