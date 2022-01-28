package com.yunussen.graduation.service;

import com.yunussen.graduation.entity.CreditEntity;
import com.yunussen.graduation.entity.CreditResult;
import com.yunussen.graduation.entity.CreditScoreEntity;
import com.yunussen.graduation.entity.UserEntity;
import com.yunussen.graduation.exception.CreditScoreNotFoundException;
import com.yunussen.graduation.exception.NotFoundCreditException;
import com.yunussen.graduation.exception.UserNotFoundException;
import com.yunussen.graduation.model.NotificationModel;
import com.yunussen.graduation.model.request.QueryCreditStateRequestModel;
import com.yunussen.graduation.repository.CreditRepository;
import com.yunussen.graduation.repository.CreditScoreRepository;
import com.yunussen.graduation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditScoreServiceImpl implements CreditScoreService {

    private final Double CREDIT_FACTOR = 4.0;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CreditScoreRepository creditScoreRepository;
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private NotificationService notificationService;

    @Transactional
    @Override
    public CreditResult queryCreditResultOfUser(String identityNumber) {

        UserEntity user = userRepository.findByIdentityNumber(identityNumber).orElseThrow(UserNotFoundException::new);
        CreditScoreEntity creditScoreEntity = creditScoreRepository.findByUserId(user.getId()).orElseThrow(CreditScoreNotFoundException::new);

        Double creditScore = creditScoreEntity.getCreditScore();
        CreditEntity creditEntity = new CreditEntity();
        creditEntity.setUserId(user.getId());

        //kredi skorlarına göre kredi durumu ve kredi bakiyesi hesabı yapıldı.
        if (creditScore < 500) {
            creditEntity.setCreditResult(CreditResult.RED);
        } else if (creditScore >= 500 && creditScore < 1000) {
            creditEntity.setCreditResult(CreditResult.ONAY);
            creditEntity.setTotalCredit(creditValueCalculate(user.getMonthlyIncome(), user.getAssurance(), creditScore));
        } else if (creditScore >= 1000) {
            creditEntity.setCreditResult(CreditResult.ONAY);
            creditEntity.setTotalCredit(creditValueCalculate(user.getMonthlyIncome(), user.getAssurance(), creditScore));
        }
        creditRepository.save(creditEntity);
        notificationService.sendSMS(new NotificationModel(user.getPhoneNumber(),creditEntity.getCreditResult()));//sms atıldı.
        return creditEntity.getCreditResult();
    }

    @Override
    public CreditResult queryCrediState(QueryCreditStateRequestModel model) {
        UserEntity user = userRepository.findByIdentityNumberAndAndBirthDate(model.getIdentityNumber(), model.getBirthDate())
                .orElseThrow(() -> new UserNotFoundException("User id and birthdate did not match"));
        if (creditRepository.findByUserIdOrderByCreatedAtDesc(user.getId()).isEmpty()) {
            throw new NotFoundCreditException("User credit not found! User Public Id: " + user.getPublicId());
        }
        return creditRepository.findByUserIdOrderByCreatedAtDesc(user.getId()).get(0).getCreditResult();
    }

    /**
     * ,
     *
     * @param monthlyIncome of user
     * @param assurance of user
     * @param crediScore of user
     * @return total credit value
     */
    private Double creditValueCalculate(Double monthlyIncome, Double assurance, Double crediScore) {
        Double totalCredit = 0.0;
        if (crediScore >= 500 && crediScore < 1000) {
            if (monthlyIncome < 5000) {
                totalCredit = 10000.0;
                if (assurance > 0) {
                    totalCredit += (assurance * 10) / 100;
                }
            } else if (monthlyIncome >= 5000 && monthlyIncome <= 10000) {
                totalCredit = 20000.0;
                if (assurance > 0) {
                    totalCredit += (assurance * 20) / 100;
                }
            } else if (monthlyIncome > 10000) {
                totalCredit = monthlyIncome * CREDIT_FACTOR / 2;
                if (assurance > 0) {
                    totalCredit += (assurance * 25) / 100;
                }
            }
        } else if (crediScore >= 1000) {
            totalCredit = monthlyIncome * CREDIT_FACTOR;
            if (assurance > 0) {
                totalCredit += (assurance * 50) / 100;
            }
        }
        return totalCredit;
    }
}
