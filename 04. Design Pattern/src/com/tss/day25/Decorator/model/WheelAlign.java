package com.tss.day25.Decorator.model;

public class WheelAlign extends CarServiceDecorator{
    public WheelAlign(ICarService carService) {
        super(carService);
    }

    @Override
    public double getCost() {
        return (400 + carService.getCost());
    }

    @Override
    public String getDescription() {
        return (super.getDescription() + ", Wheels Aligned");
    }
}
