package com.tss.day26.Observer.model;

public class WhatsAppNotifier implements AccountObserver {
    private String phoneNumber;

    public WhatsAppNotifier(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String message) {
        System.out.println("WhatsApp message sent to " + phoneNumber + ": " + message);
    }
}

