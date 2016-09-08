package com.sebbia.testtask.error.exception;

import com.sebbia.testtask.error.ApiException;

public class InvalidParameterException extends ApiException {
    public InvalidParameterException(String message) {
        super(message);
    }
}
