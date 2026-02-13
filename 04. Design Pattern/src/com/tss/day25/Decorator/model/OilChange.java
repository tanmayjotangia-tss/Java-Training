package com.tss.day25.Decorator.model;

public class OilChange extends CarServiceDecorator{
    public OilChange(ICarService carService) {
        super(carService);
    }

    @Override
    public double getCost() {
        return (500 + carService.getCost());
    }

    @Override
    public String getDescription() {
        return (super.getDescription() + ", Oil Changed");
    }
}
