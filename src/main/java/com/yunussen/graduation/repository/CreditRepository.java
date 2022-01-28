package com.yunussen.graduation.repository;

import com.yunussen.graduation.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<CreditEntity, Long> {
    List<CreditEntity> findByUserIdOrderByCreatedAtDesc(Long userId);

    CreditEntity findByUserId(Long userId);
}
