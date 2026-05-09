package com.tss.DynamicDI.controller;

import com.tss.DynamicDI.service.NotificationProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class NotificationController {
    private final NotificationProcessor notificationProcessor;

    @PostMapping("/notification")
    public void sendNotification(@RequestParam(required = false) String type,@RequestParam String msg, @RequestParam String recipient){
        notificationProcessor.send(type,msg, recipient);
    }

}
