package com.tss.day22.Order.model;

import com.tss.day22.Order.service.OrderService;

public class Order {
    private int orderID;
    private String customerName;
    private ProductCategory productCategory;
    private int quantity;
    private double pricePerUnit;
    private OrderStatus status;

    public Order(int orderID, String customerName, ProductCategory productCategory, int quantity, double pricePerUnit, OrderStatus status) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.productCategory = productCategory;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getTotalValue(){
        return this.quantity * this.pricePerUnit;
    }

    @Override
    public String toString() {
        return String.format(
                "Order ID: %d | Customer: %-14s | Category: %-11s | Qty: %2d | Unit Price: %8.2f | Total: %9.2f | Status: %s",
                orderID,
                customerName,
                productCategory,
                quantity,
                pricePerUnit,
                getTotalValue(),
                status
        );
    }

}
