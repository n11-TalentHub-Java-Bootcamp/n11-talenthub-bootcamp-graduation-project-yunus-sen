package com.yunussen.graduation.model.response;

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
