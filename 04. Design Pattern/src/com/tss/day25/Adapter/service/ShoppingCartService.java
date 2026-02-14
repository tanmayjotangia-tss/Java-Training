package com.tss.day25.Adapter.service;

import com.tss.day25.Adapter.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ShoppingCartService {

    private List<IItems> inventory;

    public ShoppingCartService() {
        this.inventory = Inventory.loadItems();
    }

    public void displayInventory() {
        System.out.println("Available Items:");
        for (int i = 0; i < inventory.size(); i++) {
            IItems item = inventory.get(i);
            System.out.println(i + " - " + item.getItemName() + " : " + item.getItemPrice());
        }
    }

    public void addItemToCart(ShoppingCart cart, IItems item) {
        cart.getItemsList().add(item);
    }

    public void removeItemFromCart(ShoppingCart cart, IItems item) {
        cart.getItemsList().remove(item);
    }

    public void displayCart(ShoppingCart cart) {
        List<IItems> cartItems = cart.getItemsList();
        if (cartItems.isEmpty()) {
            System.out.println("--- Cart is empty ---");
            return;
        }

        System.out.println("\n--- Shopping Cart ---");
        IntStream.range(0, cartItems.size())
                .forEach(i -> {
                    IItems item = cartItems.get(i);
                    System.out.println(i + ": " + item.getItemName() + " : " + item.getItemPrice());
                });

        double total = cartItems.stream()
                .mapToDouble(IItems::getItemPrice)
                .sum();
        System.out.println("Total Amount: " + total);
    }


    public double getCartTotal(ShoppingCart cart) {
        List<IItems> cartItems = cart.getItemsList();
        return cartItems.stream()
                .mapToDouble(IItems::getItemPrice)
                .sum();
    }

    public List<IItems> getInventory() {
        return inventory;
    }
}
