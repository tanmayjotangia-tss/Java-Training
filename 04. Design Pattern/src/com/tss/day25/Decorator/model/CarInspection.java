package com.tss.day25.Decorator.model;

public class CarInspection implements ICarService{
    @Override
    public double getCost() {
        return 1000;
    }

    @Override
    public String getDescription() {
        return "Simple Car";
    }
}
