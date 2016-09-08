package com.sebbia.testtask.base.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sebbia.testtask.error.ApiException;

public class ErrorResponse extends Response {

    private ApiException exception;

    public ErrorResponse(ApiException exception) {
        super(exception.getCode().getValue());
        this.exception = exception;
    }

    @JsonProperty
    public String getMessage() {
        return exception.getMessage();
    }

}
