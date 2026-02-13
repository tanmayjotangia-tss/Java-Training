package com.tss.day25.Decorator.model;

public abstract class CarServiceDecorator implements ICarService{
    ICarService carService;
    public CarServiceDecorator(ICarService carService){
        this.carService=carService;
    }
    public abstract double getCost();

    public String getDescription() {
        return carService.getDescription();
    }
}
