package com.yunussen.graduation.service;

import com.yunussen.graduation.entity.UserEntity;
import com.yunussen.graduation.exception.UserNotFoundException;
import com.yunussen.graduation.repository.UserRepository;
import com.yunussen.graduation.shared.dto.UserDto;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest extends TestCase {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ModelMapper modelMapper;

    private UserDto userDto;
    private UserEntity user;

    @Before
    public void setup() {
        Date date = new Date();
        userDto = new UserDto();
        userDto.setBirthDate(date);
        userDto.setIdentityNumber("17838043128");
        userDto.setMonthlyIncome(102.0);
        userDto.setPhoneNumber("05369853625");
        userDto.setNameSurname("yunus şen");
        userDto.setAssurance(100.0);
        userDto.setPublicId("user");

        user = new UserEntity();
        user.setMonthlyIncome(100.0);
        user.setNameSurname("yunus şen");
        user.setIdentityNumber("17838043128");
        user.setBirthDate(date);
        user.setPhoneNumber("17838043128");
        user.setAssurance(100.0);
        user.setPublicId("publicId");
        user.setId(1L);
    }

    @Test(expected = UserNotFoundException.class)
    public void shouldUpdateWhenUserNotFoundException() {
        when(userRepository.findByPublicId(anyString())).thenReturn(Optional.empty());
        userService.update(anyString(), userDto);
    }

    @Test
    public void shouldUpdate() {
        when(userRepository.findByPublicId(anyString())).thenReturn(Optional.of(user));
        when(userRepository.save(any(UserEntity.class))).thenReturn(user);
        when(modelMapper.map(user, UserDto.class)).thenReturn(userDto);
        assertEquals(userService.update(userDto.getPublicId(), userDto).getIdentityNumber(), userDto.getIdentityNumber());
    }

    @Test
    public void shouldSave() {
        when(userRepository.save(any(UserEntity.class))).thenReturn(user);
        when(modelMapper.map(userDto, UserEntity.class)).thenReturn(user);
        when(modelMapper.map(user, UserDto.class)).thenReturn(userDto);
        assertEquals(userService.save(userDto).getIdentityNumber(), userDto.getIdentityNumber());

    }

}