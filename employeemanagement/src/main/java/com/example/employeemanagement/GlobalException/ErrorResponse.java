package com.example.employeemanagement.GlobalException;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private final String message;

    private final HttpStatus httpStatus;
    
}
