package com.tss.day24.Abstract_Factory.model;


public class MarutiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return Maruti.getInstance();
    }
}
