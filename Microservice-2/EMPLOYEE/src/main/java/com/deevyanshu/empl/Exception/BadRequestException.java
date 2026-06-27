package com.deevyanshu.empl.Exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException{

        private String message;

        private HttpStatus status;

        public BadRequestException(String message) {
            this.message = message;
            this.status = HttpStatus.BAD_REQUEST;
        }

        public HttpStatus getStatus() {
            return status;
        }
        @Override
        public String getMessage() {
            return message;
        }
}
