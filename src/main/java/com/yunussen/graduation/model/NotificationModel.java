package com.yunussen.graduation.model;

import com.yunussen.graduation.entity.CreditResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class NotificationModel {
    private final String MESSAGE="kredi Sonucunuz: ";
    @NotBlank
    private String phoneNumber;
    @NotNull
    private CreditResult creditResult;

    public NotificationModel(String phoneNumber,CreditResult creditResult){
        this.creditResult=creditResult;
        this.phoneNumber=phoneNumber;
    }
}
