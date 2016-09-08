package com.sebbia.testtask.base.response;


import com.sebbia.testtask.error.Code;

public class SuccessResponse extends Response {

    public SuccessResponse() {
        super(Code.SUCCESS.getValue());
    }

}
