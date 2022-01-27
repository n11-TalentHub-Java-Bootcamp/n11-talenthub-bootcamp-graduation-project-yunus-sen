package com.yunussen.graduation.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class Error {
    private final HttpStatus httpStatus;
    private final String message;
    private List<String> details;

    public Error(HttpStatus httpStatus, String message){
        this.httpStatus=httpStatus;
        this.message=message;
    }

    public Error(HttpStatus httpStatus, String message, List<String> details) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.details = details;
    }

}
