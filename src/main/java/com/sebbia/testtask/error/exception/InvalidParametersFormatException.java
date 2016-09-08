package com.sebbia.testtask.error.exception;

import com.sebbia.testtask.error.ApiException;

public class InvalidParametersFormatException extends ApiException {

    public InvalidParametersFormatException(String message) {
        super(message);
    }
}
