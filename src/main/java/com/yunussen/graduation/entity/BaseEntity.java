package com.yunussen.graduation.entity;

import com.yunussen.graduation.util.GradutionStringUtils;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Column(name = "public_id",unique = true)
    private String publicId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @PreUpdate
    public void onPreUpdate() {
        updatedAt=new Date();
    }

    @PrePersist
    public void onPrePersist() {
        publicId= GradutionStringUtils.generatePublicId();
        createdAt=new Date();
    }
}
