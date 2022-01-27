package com.yunussen.graduation.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GraduationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> userHandleException(UserNotFoundException e) {
        Error error = new Error(HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }

    @ExceptionHandler(CreditScoreNotFound.class)
    public ResponseEntity<Error> creditScorehandleException(UserNotFoundException e) {
        Error error = new Error(HttpStatus.NOT_FOUND, "UserNot found.");
        return new ResponseEntity<>(error, error.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        Error error = new Error(HttpStatus.BAD_REQUEST,"Validation Error", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
