package com.sw.service.exception;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(Exception exception) {
        super(exception);
    }
}
