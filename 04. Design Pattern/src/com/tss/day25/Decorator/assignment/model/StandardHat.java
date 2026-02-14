package com.tss.day25.Decorator.assignment.model;

public class StandardHat implements IHat{
    @Override
    public String getName() {
        return "Standard Hat";
    }

    @Override
    public double getPrice() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "Standard Hat";
    }
}
