package com.yunussen.graduation.service;

import com.yunussen.graduation.entity.UserEntity;
import com.yunussen.graduation.exception.UserNotFoundException;
import com.yunussen.graduation.model.response.CreditResult;
import com.yunussen.graduation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreditScoreServiceImpl implements CreditScoreService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public CreditResult queryCreditResultOfUser(String identityNumber) {
        UserEntity user=userRepository.findByIdentityNumber(identityNumber).orElseThrow(UserNotFoundException::new);

        return null;
    }
}
