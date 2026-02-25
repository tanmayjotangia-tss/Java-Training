package com.tss.day25.Composite.app;
import com.tss.day25.Composite.model.*;

public class CompositeDemo {
    public static void main(String[] args) {

        MenuItem pizza = new MenuItem("Paneer Pizza", 120);
        MenuItem burger = new MenuItem("Veg Burger", 80);
        MenuItem coke = new MenuItem("Coke", 30);
        MenuItem juice = new MenuItem("Orange Juice", 50);

        Menu vegMenu = new Menu("Veg Menu");
        vegMenu.add(pizza);
        vegMenu.add(burger);

        Menu drinksMenu = new Menu("Drinks");
        drinksMenu.add(coke);
        drinksMenu.add(juice);

        Menu mainMenu = new Menu("Main Menu");
        mainMenu.add(vegMenu);
        mainMenu.add(drinksMenu);

        mainMenu.showDetails();

        System.out.println("Total Price: " + mainMenu.getPrice());
    }

}
