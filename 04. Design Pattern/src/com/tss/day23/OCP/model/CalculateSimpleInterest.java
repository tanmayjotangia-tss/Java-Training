package com.tss.day23.OCP.model;

public class CalculateSimpleInterest {

    public static double calculateSimpleInterest(FixedDeposite fd){
        return ((fd.getPrincipleAmount()*fd.getFestival().getRate()*fd.getDuration())/100);
    }
}
