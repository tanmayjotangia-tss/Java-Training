package com.tss.day26.Observer.exceptions;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(double amount) {
        super("Invalid amount entered: " + amount +
                ". Amount must be greater than zero.");
    }
}


