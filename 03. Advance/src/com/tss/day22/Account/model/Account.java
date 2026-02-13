package com.tss.day22.Account.model;

public class Account {
    private int accountNumber;
    private double balance;
    private String name;

    public Account(int accNumber, String name, double balance){
        this.accountNumber=accNumber;
        this.name=name;
        this.balance=balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
