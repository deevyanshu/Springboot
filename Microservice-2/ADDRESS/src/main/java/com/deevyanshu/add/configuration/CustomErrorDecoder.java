package com.deevyanshu.add.configuration;

import com.deevyanshu.add.Exception.CustomException;
import com.deevyanshu.add.Exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;

import java.io.InputStream;

public class CustomErrorDecoder implements ErrorDecoder {

    //we are using error decoder because although we are handling exception in service impl class of address
    // but feign will wrap any non 2xx response into a generic FeignException
    // (specifically a FeignException.NotFound for 404s).If you don't handle this, your Address Service
    // will blow up with a generic internal server error (500) or raw Feign logs, instead of neatly
    // propagating the "User Not Found" reality.
    @Override
    public Exception decode(String s, Response response) {
        int status= response.status();
        if(status==503)
        {
            return new BadRequestException("Employee service is down");
        }
        ObjectMapper objectMapper= new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try(InputStream is=response.body().asInputStream()){
            ErrorResponse errorResponse=objectMapper.readValue(is, ErrorResponse.class);
            return new CustomException(errorResponse.getMessage(),errorResponse.getStatus());
        } catch (Exception e) {
            throw new CustomException("Internal server error");
        }
    }
}
