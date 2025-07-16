package com.sw.service.exception.handler.Api;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiErr{
    private HttpStatus status;
    private String errMessage;
    private String errDescription;
    private LocalDateTime timeStamp;
    private int errCode;

    public ApiErr(){
        timeStamp = LocalDateTime.now();
    }

    public ApiErr(HttpStatus status,String errMessage, String errDescription, Throwable exception){
        this();
        this.status = status;
        this.errMessage = errMessage;
        this.errDescription = exception.getLocalizedMessage() != null ? exception.getLocalizedMessage() :
                errMessage;
//        this.errCode = status.value();
    }
}
