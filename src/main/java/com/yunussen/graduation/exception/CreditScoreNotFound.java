package com.yunussen.graduation.exception;

public class CreditScoreNotFound extends RuntimeException{

    private  String errorMessage;
    public  CreditScoreNotFound(String message){
        super(message);
    }

    public CreditScoreNotFound(){
        super("user not found.");
    }
}
