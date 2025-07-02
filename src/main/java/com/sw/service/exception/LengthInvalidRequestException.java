package com.sw.service.exception;

public class LengthInvalidRequestException extends InvalidRequestException {
    public static final String MESSAGE = "Length must be greater than 0";

    public LengthInvalidRequestException() {
        super(MESSAGE);
    }

    public LengthInvalidRequestException(Exception exception) {
        super(exception);
    }
}
