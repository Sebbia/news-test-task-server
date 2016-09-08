package com.sebbia.testtask.error;

import com.sebbia.testtask.utils.CaseFormat;

public abstract class ApiException extends Exception {

    private Code code;

    public ApiException(String message) {
        super(message);
        this.code = getCodeFromClassname();
    }

    public ApiException(String message, Throwable throwable) {
        super(message, throwable);
        this.code = getCodeFromClassname();
    }

    public ApiException(Code code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    private Code getCodeFromClassname() {
        String codeName = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, this.getClass().getSimpleName().replace("Exception", ""));
        Code code = Code.valueOf(codeName);
        if (code == null) {
            throw new RuntimeException("No code with name " + codeName);
        }
        return code;
    }

    public Code getCode() {
        return code;
    }
}
