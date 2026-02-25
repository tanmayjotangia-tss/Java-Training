package com.tss.day26.Observer.model;

public class EmailNotifier implements AccountObserver {
    private String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Email sent to " + email + ": " + message);
    }
}

