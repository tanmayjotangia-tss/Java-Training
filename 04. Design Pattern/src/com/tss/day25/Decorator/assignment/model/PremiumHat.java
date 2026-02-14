package com.tss.day25.Decorator.assignment.model;

public class PremiumHat implements IHat{
    @Override
    public String getName() {
        return "Premium";
    }

    @Override
    public double getPrice() {
        return 2200;
    }

    @Override
    public String getDescription() {
        return "Premium hat";
    }
}
