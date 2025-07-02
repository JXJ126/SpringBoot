package com.sw.service.exception;

public class WidthInvalidRequestException extends InvalidRequestException {
    public static final String MESSAGE = "Width can not be 0 or less";

    public WidthInvalidRequestException() {
        super(MESSAGE);
    }

    public WidthInvalidRequestException(Exception exception) {
        super(exception);
    }
}
