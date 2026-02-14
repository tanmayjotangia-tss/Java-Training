package com.tss.day25.Adapter.model;

public class Chocolate implements IItems {
    private String chocolateName;
    private double chocolateMRP;

    Chocolate(String name, double price){
        this.chocolateName=name;
        this.chocolateMRP=price;
    }

    @Override
    public String getItemName() {
        return chocolateName;
    }

    @Override
    public double getItemPrice() {
        return chocolateMRP;
    }
}
