package com.tss.day12.task.exceptions;

public class MinimumBalanceException extends RuntimeException {
    public MinimumBalanceException(double amount) {
        super(amount + " will be is below minimum balance.");
    }
}

