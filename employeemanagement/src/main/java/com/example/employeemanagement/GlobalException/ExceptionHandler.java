package com.example.employeemanagement.GlobalException;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> employeeNotFoundException(EmployeeNotFoundException ex)
    {
        ErrorResponse er=new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<?> cityNotFoundException(CityNotFoundException ex)
    {
        ErrorResponse er=new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<?> departmentNotFoundException(DepartmentNotFoundException ex)
    {
        ErrorResponse er=new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler
    public @ResponseBody ResponseEntity<HashMap<String,String>> handle(MethodArgumentNotValidException ex)
    {
        HashMap<String,String> errors=new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error->{
            String fieldname=((FieldError) error).getField();
            String errormessage=error.getDefaultMessage();
            errors.put(fieldname, errormessage);
        });
        
        return new ResponseEntity(errors,HttpStatus.BAD_REQUEST);
    }

    
    
}
