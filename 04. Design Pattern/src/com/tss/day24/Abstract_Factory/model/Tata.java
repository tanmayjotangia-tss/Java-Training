package com.tss.day24.Abstract_Factory.model;

public class Tata implements Car {
    private Tata(){};

    private static class tataInstance{
        private static final Tata INSTANCE = new Tata();
    }

    public static Tata getInstance(){
        return tataInstance.INSTANCE;
    }

    @Override
    public void drive() {
        System.out.println("Tata drives");
    }
}
