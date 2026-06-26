package com.deevyanshu.exceptionhandling.Exception;

public class StudentListEmptyException extends RuntimeException{

    public StudentListEmptyException(String message)
    {
        super(message);
    }

    public StudentListEmptyException(String message, Throwable cause)
    {
        super(message,cause);
    }

    
}
