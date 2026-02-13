package com.tss.day24.Abstract_Factory.test;

import com.tss.day24.Abstract_Factory.model.*;
import com.tss.day24.Abstract_Factory.service.FactoryProducer;
import com.tss.utils.InputUtil;

public class CarTest {

    public static void main(String[] args) {

        FactoryProducer.registerFactory("MARUTI", new MarutiFactory());
        FactoryProducer.registerFactory("TATA", new TataFactory());

        String input = InputUtil.readString("Enter the type of car you want: ");

        try {
            CarFactory factory = FactoryProducer.getFactory(input);
            Car car = factory.createCar();
            car.drive();

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid car type entered!");
        }
    }
}
