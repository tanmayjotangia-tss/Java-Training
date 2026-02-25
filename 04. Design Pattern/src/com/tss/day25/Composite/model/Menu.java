package com.tss.day25.Composite.model;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuComponent {

    private String name;
    private List<MenuComponent> items = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void add(MenuComponent component) {
        items.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Menu: " + name);
        for (MenuComponent component : items) {
            component.showDetails();
        }
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (MenuComponent component : items) {
            total += component.getPrice();
        }
        return total;
    }
}

