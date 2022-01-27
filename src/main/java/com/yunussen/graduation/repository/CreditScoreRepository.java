package com.yunussen.graduation.repository;

import com.yunussen.graduation.entity.CreditScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScoreEntity,Long> {
}
