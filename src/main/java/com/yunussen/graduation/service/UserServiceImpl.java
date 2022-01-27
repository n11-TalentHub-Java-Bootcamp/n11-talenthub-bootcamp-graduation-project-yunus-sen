package com.yunussen.graduation.service;

import com.yunussen.graduation.entity.UserEntity;
import com.yunussen.graduation.exception.UserNotFoundException;
import com.yunussen.graduation.repository.UserRepository;
import com.yunussen.graduation.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        return modelMapper.map(userRepository.save(modelMapper.map(userDto, UserEntity.class)),UserDto.class);
    }

    @Override
    public UserDto update(String publicId,UserDto userDto) {
        UserEntity user=userRepository.findByPublicId(publicId).orElseThrow(UserNotFoundException::new);
        user.setAssurance((userDto.getAssurance()));
        user.setBirthDate(userDto.getBirthDate());
        user.setIdentityNumber(userDto.getIdentityNumber());
        user.setMonthlyIncome(userDto.getMonthlyIncome());
        user.setNameSurname(userDto.getNameSurname());
        user.setMonthlyIncome(userDto.getMonthlyIncome());
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    @Override
    public void delete(String publicId) {
        UserEntity user=userRepository.findByPublicId(publicId).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }
}
