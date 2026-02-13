package com.tss.day23.SRP.test;

import com.tss.day23.SRP.model.Invoice;
import com.tss.day23.SRP.model.InvoicePrinter;

public class InvoiceTest {
    static void main() {
        Invoice invoice1 = new Invoice(1,"Invoice of first", 200, 0.5);
        Invoice invoice2 = new Invoice(2,"Invoice of second", 500,.08);

        InvoicePrinter.printInvoice(invoice1);
        InvoicePrinter.printInvoice(invoice2);
    }
}
