package com.yunussen.graduation.service;

import com.yunussen.graduation.shared.dto.UserDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
public interface UserService {
    UserDto save(@Valid UserDto userDto);
    UserDto update(@NotBlank String publicId,@Valid UserDto userDto);
    void delete(@NotBlank String publicId);
}
