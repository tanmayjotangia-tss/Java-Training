package com.tss.DynamicDI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class NotificationProcessor {
    private final Map<String, NotificationService> notificationServiceMap;
    private final NotificationService defaultNotifier;

    public void send(String type, String msg, String recipient){
        NotificationService notificationService = notificationServiceMap.get(type);

        if(notificationService != null){
            notificationService.sendNotification(msg, recipient);
            return;
        }
        defaultNotifier.sendNotification(msg, recipient);
    }
}
