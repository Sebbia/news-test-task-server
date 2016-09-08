package com.sebbia.testtask.error.exception;

import com.sebbia.testtask.error.ApiException;

public class MissingParameterException extends ApiException {
    public MissingParameterException(String message) {
        super(message);
    }
}
