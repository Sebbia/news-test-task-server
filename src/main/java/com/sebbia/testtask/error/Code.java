package com.sebbia.testtask.error;

public enum Code {
    SUCCESS(0),
    METHOD_NOT_FOUND(3),
    INVALID_PARAMETERS_FORMAT(4),
    INTERNAL_ERROR(5),
    INVALID_HTTP_METHOD(6),
    INVALID_PARAMETER(8),
    MISSING_PARAMETER(9),
    OBJECT_NOT_FOUND(14);

    private final int value;

    private Code(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
