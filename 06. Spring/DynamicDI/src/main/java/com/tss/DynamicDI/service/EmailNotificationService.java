package com.tss.DynamicDI.service;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailNotificationService implements NotificationService{

    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending email to: "+recipient + " Message: " + message);
    }
}
