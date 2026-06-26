package com.deevyanshu.exceptionhandling.Exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private final String message;

    private final Throwable throwable;

    private final HttpStatus httpStatus;

    public ErrorResponse(String message, Throwable throwable, HttpStatus httpStatus)
    {
        this.message=message;
        this.httpStatus=httpStatus;
        this.throwable=throwable;
    }
    
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }
    
}
