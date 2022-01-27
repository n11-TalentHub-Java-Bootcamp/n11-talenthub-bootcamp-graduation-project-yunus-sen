package com.yunussen.graduation.shared.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseDto implements Serializable {
    private String publicId;
    private Date createdAt;
    private Date updatedAt;
}
