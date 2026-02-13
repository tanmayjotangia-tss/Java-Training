package com.tss.day24.Factory.service;

import com.tss.day24.Factory.model.Car;
import com.tss.day24.Factory.model.CarType;
import com.tss.day24.Factory.model.Maruti;
import com.tss.day24.Factory.model.Tata;

public class CarFactory {
    private CarFactory(){};

    public static Car createCar(CarType carType){
        if(carType == CarType.MARUTI){
            return Maruti.getInstance();
        }

        if (carType == CarType.TATA){
            return Tata.getInstance();
        }
        return null;
    }
}