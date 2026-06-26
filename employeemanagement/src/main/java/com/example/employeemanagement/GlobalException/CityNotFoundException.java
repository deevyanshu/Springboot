package com.example.employeemanagement.GlobalException;

public class CityNotFoundException extends RuntimeException{

    public CityNotFoundException(String message)
    {
        super(message);
    }
    
}
