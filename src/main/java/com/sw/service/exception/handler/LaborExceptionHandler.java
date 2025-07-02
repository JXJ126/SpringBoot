package com.sw.service.exception.handler;

import com.sw.service.exception.PpuInvalidRequestException;
import com.sw.service.exception.WidthInvalidRequestException;
import com.sw.service.exception.handler.Api.ApiErr;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class LaborExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> LengthInvalidRequestException(MethodArgumentNotValidException exception) {
//        return null;
        String INVALID_LENGTH = "Invalid length";
        ApiErr apiErr = new ApiErr(BAD_GATEWAY, INVALID_LENGTH,BAD_REQUEST.getReasonPhrase(), exception);
        return new ResponseEntity<>(apiErr,BAD_REQUEST);
    }

    @ExceptionHandler(WidthInvalidRequestException.class)
    public ResponseEntity<Object> WidthInvalidRequestException(WidthInvalidRequestException exception) {
//        return null;
        String INVALID_WIDTH = "Invalid Width";
        ApiErr apiErr = new ApiErr(BAD_GATEWAY, INVALID_WIDTH, BAD_REQUEST.getReasonPhrase(), exception);
        return new ResponseEntity<>(apiErr,BAD_REQUEST);
    }

    @ExceptionHandler(PpuInvalidRequestException.class)
    public ResponseEntity<Object> PpuInvalidRequestException(PpuInvalidRequestException exception) {
//        return null;
        String INVALID_PPU = "Invalid Price Per Square Feet";
        ApiErr apiErr = new ApiErr(BAD_GATEWAY, INVALID_PPU, BAD_REQUEST.getReasonPhrase(), exception);
        return new ResponseEntity<>(apiErr,BAD_REQUEST);
    }
}
