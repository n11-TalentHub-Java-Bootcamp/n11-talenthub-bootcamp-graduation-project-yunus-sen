package com.yunussen.graduation.service;

import com.yunussen.graduation.model.NotificationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    private final Logger LOGGER = LoggerFactory.getLogger(NotificationServiceImpl.class);
    @Override
    public void sendSMS(NotificationModel model) {
        LOGGER.info(model.getPhoneNumber()+" nolu numaraya "+model.getMESSAGE()+model.getCreditResult()+". SMS gönderildi.");
    }
}
