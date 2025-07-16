package com.sw.service.exception.handler;

import com.sw.service.exception.InvalidRequestException;
import com.sw.service.exception.LengthInvalidRequestException;
import com.sw.service.exception.PpuInvalidRequestException;
import com.sw.service.exception.WidthInvalidRequestException;
import com.sw.service.exception.handler.Api.ApiErr;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class LaborExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> InvalidRequestException(MethodArgumentNotValidException exception) {
//        return null;
        String INVALID_LENGTH = "Invalid Input";
        ApiErr apiErr = new ApiErr(BAD_REQUEST, INVALID_LENGTH,BAD_REQUEST.getReasonPhrase(), exception);
        return new ResponseEntity<>(apiErr,BAD_REQUEST);
    }
}
