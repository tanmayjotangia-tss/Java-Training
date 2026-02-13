package com.tss.day23.SRP.model;

public class InvoicePrinter {
    public static void printInvoice(Invoice invoice){
        double taxAmount = TaxCalculator.calculateTax(invoice);
        double totalAmount = invoice.getAmount() + taxAmount;
        System.out.println("-------Invoice------");
        System.out.println("ID: " + invoice.getId());
        System.out.println("Description: " + invoice.getDescription());
        System.out.println("Amount: " + invoice.getAmount());
        System.out.println("Tax Percentage: " + invoice.getTaxPercentage());
        System.out.println("Tax amount: " + taxAmount);
        System.out.println("Total Amount: " + totalAmount);
    }
}
