package com.example.hospitalmanagement.Error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {

    private LocalDateTime timestamp;
    private String error;
    private HttpStatus ststuscode;

    public ApiError(){
        this.timestamp=LocalDateTime.now();
    }

    public ApiError(String error, HttpStatus statuscode){
        this();
        this.error=error;
        this.ststuscode=statuscode;
    }
    
}
