package com.tss.day25.Decorator.assignment.test;

import com.tss.day25.Decorator.assignment.model.*;
import com.tss.utils.InputUtil;

public class HatTest {
    public static void main(String[] args) {

        IHat hat = null;

        System.out.println("Welcome to the Hat Shop!");
        while (true) {
            System.out.println("\nSelect Base Hat:");
            System.out.println("1. Standard Hat");
            System.out.println("2. Premium Hat");

            int baseChoice = InputUtil.readInt("Enter choice: ");

            switch (baseChoice) {
                case 1 -> hat = new StandardHat();
                case 2 -> hat = new PremiumHat();
                default -> System.out.println("Invalid choice! Please select again.");
            }

            if (hat != null) break;
        }

        boolean addingDecorators = true;
        while (addingDecorators) {
            System.out.println("\nSelect Decoration to Add:");
            System.out.println("1. Golden Hat (+200)");
            System.out.println("2. Ribbon Hat (+100)");
            System.out.println("3. Finish");

            int decorChoice = InputUtil.readInt("Enter choice: ");

            switch (decorChoice) {
                case 1 -> {
                    if (!hasDecorator(hat, GoldenHat.class)) {
                        hat = new GoldenHat(hat);
                        System.out.println("Added Golden Hat decoration!");
                    } else {
                        System.out.println("Golden Hat already added!");
                    }
                }
                case 2 -> {
                    if (!hasDecorator(hat, RibbonHat.class)) {
                        hat = new RibbonHat(hat);
                        System.out.println("Added Ribbon Hat decoration!");
                    } else {
                        System.out.println("Ribbon Hat already added!");
                    }
                }

                case 3 -> addingDecorators = false;
                default -> System.out.println("Invalid option! Try again.");
            }
        }

        System.out.println("\n--- Final Hat Details ---");
        System.out.println("Name: " + hat.getName());
        System.out.println("Price: " + hat.getPrice());
        System.out.println("Description: " + hat.getDescription());

        System.out.println("\nThank you for visiting the Hat Shop!");
    }

    public static boolean hasDecorator(IHat hat, Class<?> decoratorClass) {
        while (hat instanceof HatDecorator) {
            if (decoratorClass.isInstance(hat)) {
                return true;
            }
            hat = ((HatDecorator) hat).getWrappedHat();
        }
        return false;
    }
}
