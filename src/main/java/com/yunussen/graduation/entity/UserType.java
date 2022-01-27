package com.yunussen.graduation.entity;

public enum UserType {
    USER("kullanici"),
    CUSTOMER("musteri");
    private String description;
    UserType(String description){
        this.description=description;
    }
    private String description(){
        return this.description;
    }
}
