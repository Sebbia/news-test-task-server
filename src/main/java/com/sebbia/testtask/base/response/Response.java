package com.sebbia.testtask.base.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public abstract class Response {

    private int code;

    public Response(int code) {
        this.code = code;
    }

    @JsonProperty
    @ApiModelProperty(value = "Код результата операции", required = true)
    public int getCode() {
        return code;
    }

}
