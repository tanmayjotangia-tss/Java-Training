package com.tss.day23.OCP.model;

public class FDDetailPrinter {
    private FixedDeposite fd;

    public static void displayFDDetails(FixedDeposite fd){

        double simpleInterest = CalculateSimpleInterest.calculateSimpleInterest(fd);
        double compoundInterest = CalculateCompoundInterest.calculateCompoundInterest(fd);

        System.out.println("----FD Details------");
        System.out.println("Account Number: " + fd.getAcountNumber());
        System.out.println("Principle Amount: " + fd.getPrincipleAmount());
        System.out.println("Festival: " + fd.getFestival());
        System.out.println("Festival Rate: " + fd.getFestival().getRate());
        System.out.println("Duration: " + fd.getDuration());
        System.out.println("Simple Interest: " + simpleInterest);
        System.out.println("Compound Interest: " + compoundInterest);
    }
}
