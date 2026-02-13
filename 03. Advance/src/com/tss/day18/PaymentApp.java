package com.tss.day18;

import com.tss.utils.InputUtil;

public class PaymentApp {
    public static void main(String[] args){
        double amount = InputUtil.readDouble("Emter the amount to pay: ");
        Payment creditCard = amt-> amt <= 100000;
        System.out.println("Processing Credit Card payment of " + amount);
        processPayment(creditCard,amount);

        Payment upi = amt -> amt <= 50000;
        System.out.println("Processing UPI payment of " + amount);
        processPayment(upi,amount);

        Payment netBanking = amt -> true;
        System.out.println("Processing NetBanking payment of " + amount);
        processPayment(netBanking,amount);
    }

    public static void processPayment(Payment payment,double amount){
        boolean result = payment.pay(amount);

        if(result){
            System.out.println("Payment Successful");
        }else {
            System.out.println("Payment Failed");
        }
    }
}

