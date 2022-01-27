package com.yunussen.graduation.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryCreditStateRequestModel {
    @NotBlank(message = "Identity number not emty.")
    private String identityNumber;
    @NotNull
    private Date birthDate;
}
