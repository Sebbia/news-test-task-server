package com.sebbia.testtask.error.exception;

import com.sebbia.testtask.error.ApiException;

public class InvalidHttpMethodException extends ApiException {

    public InvalidHttpMethodException(String message) {
        super(message);
    }

}
