package com.deevyanshu.validation.Exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {

    
    /*@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody ResponseEntity<Object> handle(MethodArgumentNotValidException ex)
    {
        return new ResponseEntity("values not filled properly",HttpStatus.BAD_REQUEST);
    }*/

    //use below when to display message declared in entity class or else use above for creating validation without message
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
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
