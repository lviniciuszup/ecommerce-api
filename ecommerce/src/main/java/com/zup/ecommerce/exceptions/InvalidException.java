package com.zup.ecommerce.exceptions;


import jakarta.persistence.EntityExistsException;

public abstract class InvalidException extends EntityExistsException {
    public InvalidException(String message){
        super(message);
    }
}
