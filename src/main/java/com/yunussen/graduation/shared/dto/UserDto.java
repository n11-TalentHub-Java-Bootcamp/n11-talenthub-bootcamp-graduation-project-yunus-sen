package com.yunussen.graduation.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto{
    private String nameSurname;
    private String phoneNumber;
    private String identityNumber;
    private Double monthlyIncome;
    private Date birthDate;
    private Double assurance;

}
