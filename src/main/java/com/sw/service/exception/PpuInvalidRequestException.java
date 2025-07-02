package com.sw.service.exception;

public class PpuInvalidRequestException extends InvalidRequestException {
    public static final String MESSAGE = "Ppu can not be 0 or less";

    public PpuInvalidRequestException() {
        super(MESSAGE);
    }

    public PpuInvalidRequestException(Exception exception) {
        super(exception);
    }

}
