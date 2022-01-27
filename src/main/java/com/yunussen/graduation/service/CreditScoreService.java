package com.yunussen.graduation.service;

import com.yunussen.graduation.entity.CreditResult;
import com.yunussen.graduation.model.request.QueryCreditStateRequestModel;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Validated
public interface CreditScoreService {
    CreditResult queryCreditResultOfUser(@NotBlank String identityNumber);
    CreditResult queryCrediState(@Valid QueryCreditStateRequestModel model);
}
