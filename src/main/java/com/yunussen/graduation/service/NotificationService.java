package com.yunussen.graduation.service;

import com.yunussen.graduation.model.NotificationModel;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface NotificationService {
    public void sendSMS(@Valid NotificationModel model);
}
