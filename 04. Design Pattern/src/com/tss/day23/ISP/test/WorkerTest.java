package com.tss.day23.ISP.test;

import com.tss.day23.ISP.model.Animal;
import com.tss.day23.ISP.model.Human;
import com.tss.day23.ISP.model.Phone;
import com.tss.day23.ISP.model.Robot;

public class WorkerTest {
    static void main() {
        Human tanmay = new Human();
        Robot chiti = new Robot();
        Animal bolt = new Animal();
        Phone samsung = new Phone();

        System.out.println("Human activities");
        tanmay.works();
        tanmay.rest();
        tanmay.eat();

        System.out.println("Robot Activities");
        chiti.works();
        chiti.charge();

        System.out.println("Animal Activities");
        bolt.works();
        bolt.rest();
        bolt.eat();

        System.out.println("Phone Activities");
        samsung.works();
        samsung.charge();
    }
}
