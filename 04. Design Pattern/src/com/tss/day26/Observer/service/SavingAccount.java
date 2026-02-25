package com.tss.day26.Observer.service;


import com.tss.day26.Observer.exceptions.MinimumBalanceException;
import com.tss.day26.Observer.exceptions.NegativeAmountException;
import com.tss.day26.Observer.model.Account;
import com.tss.day26.Observer.model.Transaction;

public class SavingAccount extends Account {
    //    private double offerRate;
    private final double OFFER_RATE=0.5;

    public SavingAccount(String name,double balance){
        super(name,balance);
//        this.offerRate=offerRate;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException(amount);
        }
        double balanceBefore=getBalance();
        double interest = 0;
        double finalAmount=amount;
        if (amount > 50000) {
            interest = amount * OFFER_RATE / 100;
            finalAmount+=interest;
            System.out.println("Offer Interest Added: " + interest);
        }
        increaseBalance(finalAmount);

        Transaction transaction = new Transaction("Deposit",0,getAccountNumber(),amount,balanceBefore,getBalance());
        addTransaction(transaction);
        notifyObservers("Deposit of " + amount + " made to account " + getAccountNumber() + ". New Balance: " + getBalance());

//        System.out.println("Deposit successful.");
    }


    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException(amount);
        }
        double balanceBefore=getBalance();
        if (amount <= getBalance()) {
            decreaseBalance(amount);
            Transaction transaction = new Transaction("Withdraw",getAccountNumber(),0,amount,balanceBefore,getBalance());
            addTransaction(transaction);
            notifyObservers("Withdraw of " + amount + " made to account " + getAccountNumber() + ". New Balance: " + getBalance());
//            System.out.println("Withdraw Successful");
        } else {
            throw new MinimumBalanceException(amount);
        }
    }

}


