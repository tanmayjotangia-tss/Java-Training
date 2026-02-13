package com.tss.day24.Factory.test;

import com.tss.day24.Factory.model.Car;
import com.tss.day24.Factory.model.CarType;
import com.tss.day24.Factory.service.CarFactory;
import com.tss.utils.InputUtil;

public class CarTest {
    static void main() {
        String input = InputUtil.readString("Enter car type (MARUTI / TATA): ");

        try {
            CarType carType = CarType.valueOf(input.toUpperCase());
            Car car = CarFactory.createCar(carType);
            car.drive();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid car type entered!");
        }
    }
}
