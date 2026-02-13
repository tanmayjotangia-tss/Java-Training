package com.tss.day23.ISP.model;

public class Human implements ILiving{
    @Override
    public void eat() {
        System.out.println("Human Eats");
    }

    @Override
    public void rest() {
        System.out.println("Human takes rest");
    }

    @Override
    public void works() {
        System.out.println("Human started working");
    }
}
