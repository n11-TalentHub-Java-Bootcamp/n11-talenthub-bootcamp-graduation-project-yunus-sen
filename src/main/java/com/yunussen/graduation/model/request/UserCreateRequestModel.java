package com.yunussen.graduation.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UserCreateRequestModel {
    @NotBlank(message = "first name must not be empty")
    private String nameSurname;
    @NotBlank(message = "identity number name must not be empty")
    private String identityNumber;
    @NotBlank(message = "phone number name must not be empty")
    private String phoneNumber;
    @NotNull(message = "monthlyIncome must not be empty")
    private Double monthlyIncome;
    @NotNull(message = "bithdate must not be empty")
    private Date birthDate;
    private Double assurance;
}
