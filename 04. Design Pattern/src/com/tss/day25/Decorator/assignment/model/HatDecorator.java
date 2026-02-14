package com.tss.day25.Decorator.assignment.model;

public abstract class HatDecorator implements IHat {
    IHat hat;

    public HatDecorator(IHat hat){
        this. hat = hat;
    }
    public abstract String getName();
    public abstract double getPrice();
    public abstract String getDescription();
    public IHat getWrappedHat() {
        return hat;
    }
}
