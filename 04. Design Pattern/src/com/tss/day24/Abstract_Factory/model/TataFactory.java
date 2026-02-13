package com.tss.day24.Abstract_Factory.model;

public class TataFactory implements CarFactory {
    @Override
    public Car createCar() {
        return Tata.getInstance();
    }
}
