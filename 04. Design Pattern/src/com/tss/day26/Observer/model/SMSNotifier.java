package com.tss.day26.Observer.model;

public class SMSNotifier implements AccountObserver {
    private String phoneNumber;

    public SMSNotifier(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String message) {
        System.out.println("SMS sent to " + phoneNumber + ": " + message);
    }
}

