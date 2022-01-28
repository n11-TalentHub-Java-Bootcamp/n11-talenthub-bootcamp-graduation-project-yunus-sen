package com.yunussen.graduation.listener;

import com.yunussen.graduation.entity.CreditScoreEntity;
import com.yunussen.graduation.entity.UserEntity;
import com.yunussen.graduation.repository.CreditScoreRepository;
import com.yunussen.graduation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InitializerData {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CreditScoreRepository creditScoreRepository;

    @EventListener
    public void handleEvent(ContextRefreshedEvent event) {

        UserEntity user = new UserEntity();
        user.setMonthlyIncome(100.0);
        user.setNameSurname("yunus şen");
        user.setIdentityNumber("17838043128");
        user.setBirthDate(new Date());
        user.setPhoneNumber("17838043128");
        user.setAssurance(100.0);
        UserEntity storedUser;

        if (!userRepository.findByIdentityNumber(user.getIdentityNumber()).isPresent()) {
            storedUser = userRepository.save(user);
        } else {
            storedUser = userRepository.findByIdentityNumber(user.getIdentityNumber()).get();
        }

        if (!creditScoreRepository.findByUserId(storedUser.getId()).isPresent()) {
            CreditScoreEntity creditScoreEntity = new CreditScoreEntity();
            creditScoreEntity.setCreditScore(600.0);
            creditScoreEntity.setUserId(storedUser.getId());
            creditScoreRepository.save(creditScoreEntity);
        }
    }
}
