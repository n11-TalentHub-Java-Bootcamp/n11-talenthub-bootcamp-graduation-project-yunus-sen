package com.yunussen.graduation.service;

import com.yunussen.graduation.model.response.CreditResult;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public interface CreditScoreService {
    CreditResult queryCreditResultOfUser(@NotBlank String identityNumber);
}
