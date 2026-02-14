package com.tss.day25.Adapter.app;

import com.tss.day25.Adapter.model.*;
import com.tss.day25.Adapter.service.ShoppingCartService;
import com.tss.utils.InputUtil;

import java.util.List;

public class ShoppingApp {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        ShoppingCartService service = new ShoppingCartService();

        while (true) {
            displayMenu();
            int choice = InputUtil.readInt("Enter choice: ");

            switch (choice) {
                case 1 -> service.displayInventory();

                case 2 -> {
                    while(true){
                        service.displayInventory();
                        int addIndex = InputUtil.readInt("Enter item number to add: ");
                        List<IItems> inventory = service.getInventory();
                        if (addIndex >= 0 && addIndex < inventory.size()) {
                            service.addItemToCart(cart, inventory.get(addIndex));
                            System.out.println("Added: " + inventory.get(addIndex).getItemName());
                        }else{
                            System.out.println("Invalid selection!");
                        }
                        if(!InputUtil.confirmAction("Do you want to add more items ? ")) break;
                    }
                }

                case 3 -> {
                    while(true){
                        service.displayCart(cart);
                        int removeIndex = InputUtil.readInt("Enter item number to remove: ");
                        List<IItems> cartItems = cart.getItemsList();
                        if (removeIndex >= 0 && removeIndex < cartItems.size()) {
                            IItems removedItem = cartItems.get(removeIndex);
                            service.removeItemFromCart(cart, removedItem);
                            System.out.println("Removed: " + removedItem.getItemName());
                        }else {
                            System.out.println("Invalid selection!");
                        }

                        if(!InputUtil.confirmAction("Do you want to remove more items ? ")) break;
                    }
                }

                case 4 -> service.displayCart(cart);

                case 5 -> {System.out.println("\n--- Checkout ---");
                    System.out.println("Total Amount : " + service.getCartTotal(cart));
                    System.out.println("Thank you for shopping!");
                    return;
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static void displayMenu(){
        System.out.println("\nWelcome to the Shopping Cart System!\n");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Item to Cart");
        System.out.println("3. Remove Item from Cart");
        System.out.println("4. View Cart");
        System.out.println("5. Checkout & Exit");
    }
}
