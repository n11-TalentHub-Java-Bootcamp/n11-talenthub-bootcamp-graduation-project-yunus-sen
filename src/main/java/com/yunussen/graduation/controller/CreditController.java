package com.yunussen.graduation.controller;

import com.yunussen.graduation.entity.CreditResult;
import com.yunussen.graduation.model.request.QueryCreditStateRequestModel;
import com.yunussen.graduation.service.CreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/credit")
public class CreditController {

    @Autowired
    private CreditScoreService creditScoreService;

    @GetMapping("/query/{identity-number}")
    public ResponseEntity<CreditResult> getCreditResultOfUser(@PathVariable(value = "identity-number") @NotBlank String identityNumber){
        return ResponseEntity.ok(creditScoreService.queryCreditResultOfUser(identityNumber));
    }
    @PostMapping("/query-credit")
    public ResponseEntity<CreditResult> queryCreditState(@RequestBody @Valid QueryCreditStateRequestModel model){
        return ResponseEntity.ok(creditScoreService.queryCrediState(model));
    }

}
