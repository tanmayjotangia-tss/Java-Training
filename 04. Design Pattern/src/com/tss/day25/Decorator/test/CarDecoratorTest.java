package com.tss.day25.Decorator.test;

import com.tss.day25.Decorator.model.CarInspection;
import com.tss.day25.Decorator.model.ICarService;
import com.tss.day25.Decorator.model.OilChange;
import com.tss.day25.Decorator.model.WheelAlign;

public class CarDecoratorTest {
    static void main() {
        ICarService carService = new CarInspection();
        System.out.println(carService.getCost());
        System.out.println(carService.getDescription());

        //Same car went for oil change
        carService = new OilChange(carService);
        System.out.println(carService.getCost());
        System.out.println(carService.getDescription());

        //Same car went for wheel alignment
        carService = new WheelAlign(carService);
        System.out.println(carService.getCost());
        System.out.println(carService.getDescription());
    }
}
