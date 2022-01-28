package com.yunussen.graduation.exception;

public class NotFoundCreditException extends RuntimeException {

    private String errorMessage;

    public NotFoundCreditException(String message) {
        super(message);
    }
}