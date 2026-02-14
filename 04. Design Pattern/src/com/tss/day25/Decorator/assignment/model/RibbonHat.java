package com.tss.day25.Decorator.assignment.model;

public class RibbonHat extends HatDecorator{
    public RibbonHat(IHat hat) {
        super(hat);
    }

    @Override
    public String getName() {
        return "Ribboned " + hat.getName();
    }

    @Override
    public double getPrice() {
        return 100 + hat.getPrice();
    }

    @Override
    public String getDescription() {
        return "Ribboned, " + hat.getDescription();
    }
}
