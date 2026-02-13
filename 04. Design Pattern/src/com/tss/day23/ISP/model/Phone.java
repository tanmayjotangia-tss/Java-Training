package com.tss.day23.ISP.model;

public class Phone implements INonLiving {
    @Override
    public void charge() {
        System.out.println("Phone charges");
    }

    @Override
    public void works() {
        System.out.println("Phone is working");
    }
}
