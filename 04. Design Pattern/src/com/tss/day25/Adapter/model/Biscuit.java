package com.tss.day25.Adapter.model;

public class Biscuit implements IItems {
    private String biscuitName;
    private double biscuitMRP;


    Biscuit(String name, double price){
        this.biscuitName = name;
        this.biscuitMRP = price;
    }

    @Override
    public String getItemName() {
        return biscuitName;
    }

    @Override
    public double getItemPrice() {
        return biscuitMRP;
    }
}
