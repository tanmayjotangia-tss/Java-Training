package com.tss.day23.OCP.model;

public class NewYear implements IFestival{

    private final double NEW_YEAR_RATE = 0.2;

    @Override
    public double getRate() {
        return NEW_YEAR_RATE;
    }

    @Override
    public String toString() {
        return "New Year";
    }
}
