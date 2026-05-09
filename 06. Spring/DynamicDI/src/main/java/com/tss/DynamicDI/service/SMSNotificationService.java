package com.tss.DynamicDI.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("sms")
public class SMSNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending sms to: "+recipient + " Message: " + message);
    }
}
