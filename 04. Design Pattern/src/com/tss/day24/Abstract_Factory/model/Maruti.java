package com.tss.day24.Abstract_Factory.model;

public class Maruti implements Car {
    private Maruti(){};

    private static class marutiInstance{
        private static final Maruti INSTANCE = new Maruti();
    }

    public static Maruti getInstance(){
        return marutiInstance.INSTANCE;
    }

    @Override
    public void drive() {
        System.out.println("Maruti drives");
    }
}
