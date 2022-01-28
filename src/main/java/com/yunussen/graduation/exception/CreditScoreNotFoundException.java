package com.yunussen.graduation.exception;

public class CreditScoreNotFoundException extends RuntimeException{

    private  String errorMessage;
    public CreditScoreNotFoundException(String message){
        super(message);
    }

    public CreditScoreNotFoundException(){
        super("user not found.");
    }
}
