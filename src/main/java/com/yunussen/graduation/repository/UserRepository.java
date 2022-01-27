package com.yunussen.graduation.repository;

import com.yunussen.graduation.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByPublicId(String publicId);
    Optional<UserEntity>findByIdentityNumber(String identityNumber);
}
