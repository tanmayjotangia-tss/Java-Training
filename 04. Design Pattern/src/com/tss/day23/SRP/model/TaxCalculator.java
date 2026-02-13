package com.tss.day23.SRP.model;

public class TaxCalculator {
    public static double calculateTax(Invoice invoice){
        return (invoice.getAmount() * invoice.getTaxPercentage());
    }
}
