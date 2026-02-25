package com.tss.day25.Composite.model;

public class MenuItem implements MenuComponent {

    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showDetails() {
        System.out.println("Item: " + name + " | Price: " + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}

