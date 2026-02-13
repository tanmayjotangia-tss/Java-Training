package com.tss.day23.ISP.model;

public class Animal implements ILiving{
    @Override
    public void eat() {
        System.out.println("Animal eats");
    }

    @Override
    public void rest() {
        System.out.println("Animal takes rest");
    }

    @Override
    public void works() {
        System.out.println("Animal started working");
    }
}
