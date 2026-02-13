package com.tss.day22.Order.controller;

import com.tss.day22.Order.model.Order;
import com.tss.day22.Order.model.OrderStatus;
import com.tss.day22.Order.model.ProductCategory;
import com.tss.day22.Order.service.OrderService;
import com.tss.utils.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private static List<Order> orders = OrderService.getOrders();

    public static void start(){
        OrderService.dataSeeding();
        while(true){
            displayMenu();
            int choice = InputUtil.readInt("Enter Choice: ");

            switch (choice){
                case 1 -> {
                    OrderService.showCustomerName().forEach(System.out::println);
                    String customer = InputUtil.readValidName("Enter Customer Name: ");
                    OrderService.getOrdersByCustomer(orders,customer);
                }
                case 2 -> {
                    OrderService.showStatus();
                    OrderStatus status = OrderStatus.valueOf(
                            InputUtil.readString("Enter Status: ").toUpperCase()
                    );
                    OrderService.getOrdersByStatus(orders,status);
                }
                case 3 -> OrderService.getProductCategories();
                case 4 -> {
                    OrderService.showStatus();
                    OrderStatus status = OrderStatus.valueOf(
                            InputUtil.readString("Enter Status: ").toUpperCase()
                    );
                    OrderService.getTotalRevenueByStatus(orders,status);
                }
                case 5 ->{
                    OrderService.showCategories();
                    ProductCategory category = ProductCategory.valueOf(
                            InputUtil.readString("Enter Category: ").toUpperCase()
                    );
                    OrderService.getAverageQuantityByCategory(orders,category);
                }
                case 6 -> OrderService.getOrdersWithHighestValue();
                case 7 -> OrderService.getGroupCountByStatus();
                case 8 -> {
                    int orderNumber = InputUtil.readInt("Enter minimum order number");
                    OrderService.getCustomerWithOrders(orders,orderNumber);
                }
                case 9 -> {
                    int limitNumber = InputUtil.readInt("Enter the number to orders you want in decending order : ");
                    OrderService.getNDecendingOrders(orders,limitNumber);
                }
                case 10 -> {
                    OrderService.showCategories();
                    ProductCategory category = ProductCategory.valueOf(
                            InputUtil.readString("Enter Category: ").toUpperCase()
                    );
                    int quantityNumber = InputUtil.readInt("Enter the number of max order: ");
                    OrderService.isQuantityLessThanN(orders,category,quantityNumber);
                }
                case 0 -> {
                    System.out.println("Exiting....");
                    return;
                }
                default -> System.out.println("Enter valid choice !!");
            }
        }
    }

    private static void displayMenu(){
        System.out.println("\n---------Orders Menu-------");
        System.out.println("1. Print all orders for a customer");
        System.out.println("2 .Print all orders by status");
        System.out.println("3. List all product categories");
        System.out.println("4. Total Revenue of orders by status");
        System.out.println("5. Average Quantity of Items by Category");
        System.out.println("6. Find order with highest total revenue");
        System.out.println("7. Group by status and return count");
        System.out.println("8. Customers with more than n orders");
        System.out.println("9. Top n Decending Order based on Total Value");
        System.out.println("10. Check whether the quantity of a category is less than n");
        System.out.println("0. Exit");
    }
}
