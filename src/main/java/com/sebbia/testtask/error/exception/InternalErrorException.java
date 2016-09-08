package com.sebbia.testtask.error.exception;

import com.sebbia.testtask.error.ApiException;

public class InternalErrorException extends ApiException {

    public InternalErrorException() {
        this("Unspecified internal error");
    }

    public InternalErrorException(String message) {
        super(message);
    }

}
