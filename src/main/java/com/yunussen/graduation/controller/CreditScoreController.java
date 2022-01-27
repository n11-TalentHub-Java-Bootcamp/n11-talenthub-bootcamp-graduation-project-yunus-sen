package com.yunussen.graduation.controller;

import com.yunussen.graduation.model.response.CreditResult;
import com.yunussen.graduation.service.CreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/credit-score")
public class CreditScoreController {

    @Autowired
    private CreditScoreService creditScoreService;

    @GetMapping("/{identity-number}")
    public ResponseEntity<CreditResult> getCreditResultOfUser(@PathVariable(value = "identity-number") @NotBlank String identityNumber){
        return ResponseEntity.ok(creditScoreService.queryCreditResultOfUser(identityNumber));
    }
}
