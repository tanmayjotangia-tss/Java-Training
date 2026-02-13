package com.tss.day23.SRP.model;

public class Invoice {
    private int id;
    private String Description;
    private double amount;
    private double taxPercentage;

    public Invoice(int id, String description, double amount, double taxPercentage) {
        this.id = id;
        Description = description;
        this.amount = amount;
        this.taxPercentage = taxPercentage;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return Description;
    }

    public double getAmount() {
        return amount;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

//    @Override
//    public String toString() {
//        return "Invoice: " +
//                "\nid: " + id +
//                "\nDescription: '" + Description + '\'' +
//                "\namount: " + amount +
//                "\ntaxPercentage: " + taxPercentage;
//    }
}

