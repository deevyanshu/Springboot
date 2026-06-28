package com.deevyanshu.add.Exception;

import org.springframework.http.HttpStatus;

public class MissingParameterException extends RuntimeException{

    private String message;

    private HttpStatus status;

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public MissingParameterException(String message) {
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
    }

}
