package com.tss.day26.Observer.service;


import com.tss.day26.Observer.exceptions.MinimumBalanceException;
import com.tss.day26.Observer.exceptions.NegativeAmountException;
import com.tss.day26.Observer.model.Account;
import com.tss.day26.Observer.model.Transaction;
public class CurrentAccount extends Account {
    public static final double MIN_BALANCE=500;

    public CurrentAccount(String name, double balance){
        super(name,balance);
        if(balance < MIN_BALANCE){
            throw new MinimumBalanceException(balance);
        }
    }

    public void deposit(double amount){
        if(amount <0){
            throw new NegativeAmountException(amount);
        }
        double balanceBefore = getBalance();
        increaseBalance(amount);
        Transaction transaction = new Transaction("Deposit",0,getAccountNumber(),amount,balanceBefore,getBalance());
        addTransaction(transaction);
        notifyObservers("Deposit of " + amount + " made to account " + getAccountNumber() + ". New Balance: " + getBalance());


//            System.out.println("Amount deposited successfully !!");

    }

//    public void withdraw(double amount) {
//        if (amount <= 0) {
//            throw new NegativeAmountException(amount);
//
//        }
//        if (getBalance() - amount >= MIN_BALANCE) {
//            setBalance(getBalance() - amount);
    ////            System.out.println("Withdraw Successful");
//        } else {
//            throw new MinimumBalanceException(amount);
//        }
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException(amount);
        }
        double balanceBefore=getBalance();
        double balanceAfter = getBalance() - amount;
        if (balanceAfter < MIN_BALANCE) {
            throw new MinimumBalanceException(balanceAfter);
        }
        decreaseBalance(amount);
        Transaction transaction = new Transaction("Withdraw",getAccountNumber(),0,amount,balanceBefore,getBalance());
        addTransaction(transaction);
        notifyObservers("Withdraw of " + amount + " made to account " + getAccountNumber() + ". New Balance: " + getBalance());
    }
}


