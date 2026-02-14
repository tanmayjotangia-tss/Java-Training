package com.tss.day25.Adapter.model;

public class HatAdapter implements IItems{

    private Hat hat;

    public HatAdapter(Hat hat){
        this.hat = hat;
    }

    @Override
    public String getItemName() {
        return hat.getShortName() + " | " + hat.getLongName();
    }

    @Override
    public double getItemPrice() {
        double basePrice = hat.getBasePrice();
        double taxAmount = basePrice * hat.getTax();
        return basePrice + taxAmount;
    }
}
