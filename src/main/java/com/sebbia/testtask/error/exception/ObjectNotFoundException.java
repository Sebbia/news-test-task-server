package com.sebbia.testtask.error.exception;

import com.sebbia.testtask.error.ApiException;

public class ObjectNotFoundException extends ApiException {

    public ObjectNotFoundException() {
        super("Object not found");
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(Class objectClass, Long id) {
        super(String.format("Object \"%s\" with id %d not found", objectClass.getSimpleName(), id));
    }
}
