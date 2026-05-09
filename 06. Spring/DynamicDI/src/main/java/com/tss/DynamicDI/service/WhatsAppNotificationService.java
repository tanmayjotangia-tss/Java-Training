package com.tss.DynamicDI.service;

import org.springframework.stereotype.Service;

@Service("whatsapp")
public class WhatsAppNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending WhatsApp msg to: "+recipient + " Message: " + message);
    }
}
