package com.yunussen.graduation.entity;

import lombok.Getter;

@Getter
public enum CreditResult {
    ONAY("Kredi alabilir."),
    RED("Kredi alamaz");
    private String message;
    CreditResult(String message){
        this.message=message;
    }
}
