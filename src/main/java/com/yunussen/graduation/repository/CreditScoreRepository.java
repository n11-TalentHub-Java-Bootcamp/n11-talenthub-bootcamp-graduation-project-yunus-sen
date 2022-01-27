package com.yunussen.graduation.repository;

import com.yunussen.graduation.entity.CreditScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScoreEntity,Long> {

    Optional<CreditScoreEntity> findByUserId(Long userId);
}
