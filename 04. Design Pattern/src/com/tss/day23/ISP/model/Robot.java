package com.tss.day23.ISP.model;

public class Robot implements INonLiving{
    @Override
    public void charge() {
        System.out.println("Robot is charging");
    }

    @Override
    public void works() {
        System.out.println("Robot is working");
    }
}
