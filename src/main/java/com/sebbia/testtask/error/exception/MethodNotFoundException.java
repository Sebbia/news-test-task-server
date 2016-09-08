package com.sebbia.testtask.error.exception;

import com.sebbia.testtask.error.ApiException;

public class MethodNotFoundException extends ApiException {

    public MethodNotFoundException(String apiMethodName, String httpMethod) {
        super("Method not found: " + apiMethodName + " http method: " + httpMethod);
    }
}
