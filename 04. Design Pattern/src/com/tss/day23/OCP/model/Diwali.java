package com.tss.day23.OCP.model;

public class Diwali implements IFestival{
    private final double DIWALI_RATE = 0.8;

    @Override
    public double getRate() {
        return DIWALI_RATE;
    }

    @Override
    public String toString() {
        return "Diwali";
    }
}
