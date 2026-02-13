package com.tss.day23.OCP.model;

public class CalculateCompoundInterest {

    public static double calculateCompoundInterest(FixedDeposite fd){
        double principal = fd.getPrincipleAmount();
        double rate = fd.getFestival().getRate();
        int duration = fd.getDuration();

        double amount = principal * Math.pow(1 + rate / 100, duration);
        return amount - principal;
    }
}
