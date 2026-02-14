package com.tss.day25.Decorator.assignment.model;

public class GoldenHat extends HatDecorator {
    public GoldenHat(IHat hat) {
        super(hat);
    }

    @Override
    public String getName() {
        return "Golden " + hat.getName();
    }

    @Override
    public double getPrice() {
        return 200 + hat.getPrice();
    }

    @Override
    public String getDescription() {
        return "Golden, " + hat.getDescription();
    }
}
