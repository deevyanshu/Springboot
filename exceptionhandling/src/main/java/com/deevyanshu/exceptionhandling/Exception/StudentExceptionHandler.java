package com.deevyanshu.exceptionhandling.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
    
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex)
    {
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(),
         ex.getCause(),HttpStatus.NOT_FOUND);
         return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentListEmptyException.class)
    public ResponseEntity<Object> handleStudentListEmptyException(StudentListEmptyException ex)
    {
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(), ex.getCause(), 
        HttpStatus.NO_CONTENT);
        return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);
    }
    
}
