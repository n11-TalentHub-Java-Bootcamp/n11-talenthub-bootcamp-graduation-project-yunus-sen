package com.yunussen.graduation.service;

import com.yunussen.graduation.entity.CreditEntity;
import com.yunussen.graduation.entity.CreditResult;
import com.yunussen.graduation.entity.CreditScoreEntity;
import com.yunussen.graduation.entity.UserEntity;
import com.yunussen.graduation.exception.UserNotFoundException;
import com.yunussen.graduation.model.request.QueryCreditStateRequestModel;
import com.yunussen.graduation.repository.CreditRepository;
import com.yunussen.graduation.repository.CreditScoreRepository;
import com.yunussen.graduation.repository.UserRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreditScoreServiceImplTest extends TestCase {

    @InjectMocks
    private CreditScoreServiceImpl creditScoreService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private CreditScoreRepository creditScoreRepository;
    @Mock
    private CreditRepository creditRepository;

    private UserEntity user;
    private QueryCreditStateRequestModel model;
    private CreditEntity creditEntity;
    private CreditScoreEntity creditScoreEntity;

    @Before
    public void setup() {
        model = QueryCreditStateRequestModel.builder()
                .birthDate(new Date()).identityNumber("17725093698")
                .build();

        user = new UserEntity();
        user.setMonthlyIncome(100.0);
        user.setNameSurname("yunus şen");
        user.setIdentityNumber(model.getIdentityNumber());
        user.setBirthDate(model.getBirthDate());
        user.setId(1L);
        user.setPhoneNumber("34324324");
        user.setPublicId("dsfdsfsdfs");
        user.setAssurance(0.0);

        creditEntity = new CreditEntity();
        creditEntity.setTotalCredit(10010.0);
        creditEntity.setCreditResult(CreditResult.ONAY);

        creditScoreEntity = new CreditScoreEntity();
        creditScoreEntity.setCreditScore(600.0);
        creditScoreEntity.setId(1L);
        creditScoreEntity.setUserId(1L);
        creditScoreEntity.setPublicId("sdfsdf");

    }

    @Test(expected = UserNotFoundException.class)
    public void shouldQueryCreditResultOfUserWhenUserNotFound() {
        when(userRepository.findByIdentityNumber(anyString())).thenReturn(Optional.empty());
        creditScoreService.queryCreditResultOfUser(anyString());
    }

    @Test
    public void shouldQueryCreditResultOfUserWhenFindUser() {
        when(userRepository.findByIdentityNumber(anyString())).thenReturn(Optional.of(user));
        Optional<UserEntity> storedUser = userRepository.findByIdentityNumber(anyString());
        assertEquals(storedUser.get(), user);
    }

    @Test(expected = UserNotFoundException.class)
    public void shouldQueryCrediStateWhenUserNotFound() {
        when(userRepository.findByIdentityNumberAndAndBirthDate(model.getIdentityNumber(), model.getBirthDate())).thenReturn(Optional.empty());
        creditScoreService.queryCrediState(model);
    }

    @Test
    public void shouldQueryCrediState() {
        when(userRepository.findByIdentityNumberAndAndBirthDate(model.getIdentityNumber(), model.getBirthDate())).thenReturn(Optional.of(user));
        when(creditRepository.findByUserIdOrderByCreatedAtDesc(anyLong())).thenReturn(Arrays.asList(creditEntity));
        assertEquals(creditScoreService.queryCrediState(model), CreditResult.ONAY);
    }

}