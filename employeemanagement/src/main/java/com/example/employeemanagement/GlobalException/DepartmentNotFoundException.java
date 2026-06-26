package com.example.employeemanagement.GlobalException;

public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException(String message)
    {
        super(message);
    }
    
}
