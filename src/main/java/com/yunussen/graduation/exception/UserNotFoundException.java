package com.yunussen.graduation.exception;

public class UserNotFoundException extends RuntimeException{
    private  String errorMessage;
    public  UserNotFoundException(String message){
        super(message);
    }

    public UserNotFoundException(){
        super("user not found.");
    }
}
