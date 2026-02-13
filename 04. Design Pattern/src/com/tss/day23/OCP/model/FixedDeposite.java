package com.tss.day23.OCP.model;

public class FixedDeposite {
    private int acountNumber;
    private int duration;
    private double principleAmount;
    private IFestival festival;

    public FixedDeposite(int acountNumber, int duration, double amount, IFestival festival) {
        this.acountNumber = acountNumber;
        this.duration = duration;
        this.principleAmount = amount;
        this.festival = festival;
    }

    public int getAcountNumber() {
        return acountNumber;
    }

    public void setAcountNumber(int acountNumber) {
        this.acountNumber = acountNumber;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrincipleAmount() {
        return principleAmount;
    }

    public void setPrincipleAmount(double principleAmount) {
        this.principleAmount = principleAmount;
    }

    public IFestival getFestival() {
        return festival;
    }

    public void setFestival(IFestival festival) {
        this.festival = festival;
    }
}
