package com.tss.day26.Observer.exceptions;

public class MinimumBalanceException extends RuntimeException {
    public MinimumBalanceException(double amount) {
        super(amount + " will be is below minimum balance.");
    }
}


