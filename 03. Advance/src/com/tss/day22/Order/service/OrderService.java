package com.tss.day22.Order.service;

import com.tss.day22.Order.model.Order;
import com.tss.day22.Order.model.OrderStatus;
import com.tss.day22.Order.model.ProductCategory;

import java.util.*;
import java.util.stream.Collectors;

public class OrderService {
    private static List<Order> orders = new ArrayList<>();

    public static void dataSeeding() {
        orders.add(new Order(1, "Alice Johnson", ProductCategory.ELECTRONICS, 2, 499.99, OrderStatus.SHIPPED));
        orders.add(new Order(2, "Bob Smith", ProductCategory.BOOKS, 5, 15.99, OrderStatus.PROCESSING));
        orders.add(new Order(3, "Alice Johnson", ProductCategory.CLOTHING, 3, 39.95, OrderStatus.DELIVERED));
        orders.add(new Order(4, "David Brown", ProductCategory.FURNITURE, 1, 799.00, OrderStatus.PENDING));
        orders.add(new Order(5, "Eva Green", ProductCategory.TOYS, 4, 24.50, OrderStatus.SHIPPED));
        orders.add(new Order(6, "Bob Smith", ProductCategory.ELECTRONICS, 1, 1299.99, OrderStatus.CANCELLED));
        orders.add(new Order(7, "Grace Lee", ProductCategory.BOOKS, 10, 9.99, OrderStatus.DELIVERED));
        orders.add(new Order(8, "Henry Adams", ProductCategory.CLOTHING, 6, 29.99, OrderStatus.PROCESSING));
        orders.add(new Order(9, "Alice Johnson", ProductCategory.TOYS, 2, 49.95, OrderStatus.SHIPPED));
        orders.add(new Order(10, "Jack Taylor", ProductCategory.FURNITURE, 1, 1200.00, OrderStatus.DELIVERED));
        orders.add(new Order(11, "David Brown", ProductCategory.ELECTRONICS, 3, 299.99, OrderStatus.SHIPPED));
        orders.add(new Order(12, "Eva Green", ProductCategory.BOOKS, 7, 12.50, OrderStatus.DELIVERED));
        orders.add(new Order(13, "Grace Lee", ProductCategory.CLOTHING, 2, 45.00, OrderStatus.PROCESSING));
        orders.add(new Order(14, "Bob Smith", ProductCategory.TOYS, 3, 19.99, OrderStatus.SHIPPED));
        orders.add(new Order(15, "Alice Johnson", ProductCategory.FURNITURE, 1, 999.00, OrderStatus.PENDING));
        orders.add(new Order(16, "Henry Adams", ProductCategory.ELECTRONICS, 1, 699.99, OrderStatus.DELIVERED));
        orders.add(new Order(17, "Jack Taylor", ProductCategory.TOYS, 5, 29.99, OrderStatus.SHIPPED));
        orders.add(new Order(18, "Eva Green", ProductCategory.CLOTHING, 3, 39.99, OrderStatus.PROCESSING));
        orders.add(new Order(19, "David Brown", ProductCategory.BOOKS, 8, 14.95, OrderStatus.DELIVERED));
        orders.add(new Order(20, "Grace Lee", ProductCategory.TOYS, 2, 24.99, OrderStatus.SHIPPED));
    }


    public static void getOrdersByCustomer(List<Order> orders, String customer) {
        System.out.println("All orders for a customer: " + customer);
        orders.stream()
                .filter(order -> order.getCustomerName()
                        .toLowerCase()
                        .contains(customer.toLowerCase()))
                .forEach(System.out::println);
    }

    public static void getOrdersByStatus(List<Order> orders, OrderStatus status) {
        System.out.println("\n " + status + "Orders");
        orders.stream()
                .filter(order -> order.getStatus() == status)
                .forEach(System.out::println);
    }


    public static void getProductCategories() {
        System.out.println("\nProduct Categories");
        orders.stream()
                .map(Order::getProductCategory)
                .distinct()
                .forEach(System.out::println);
    }

    public static void getTotalRevenueByStatus(List<Order> orders, OrderStatus status ) {
        double totalRevenueShipped = orders.stream()
                .filter(order -> order.getStatus()== status)
                .mapToDouble(Order::getTotalValue)
                .sum();
        System.out.println("Revenue of all shipped: " + totalRevenueShipped);
    }

    public static void getAverageQuantityByCategory(List<Order> orders, ProductCategory category) {
        double averageQuantity = orders.stream()
                .filter(order -> order.getProductCategory()== category)
                .mapToInt(Order::getQuantity)
                .average()
                .orElse(0.0);
        System.out.println("\nAverage quantity of items for " + category + " category: " + averageQuantity);
    }

    public static void getOrdersWithHighestValue() {
        System.out.println("\nOrder with highest total value");
        orders.stream()
                .filter(order -> order.getStatus()==OrderStatus.SHIPPED)
                .max(Comparator.comparing(Order::getTotalValue))
                .ifPresent(System.out::println);
    }

    public static void getGroupCountByStatus() {
        System.out.println("\nGroup by Status");
        orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()))
                .forEach((status, count) -> System.out.println(status + ":" + count));
    }

    public static void getCustomerWithOrders(List<Order> orders, int orderNumber) {
        System.out.println("\nCustomers with more than " + orderNumber +  " orders");
        orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerName, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(item -> item.getValue() > orderNumber)
                .forEach(System.out::println);
    }

    public static void getNDecendingOrders(List<Order> orders, int limitNumber) {
        System.out.println("\nTop " + limitNumber + " Descending Orders by Total Value");        orders.stream()
                .filter(order -> !(order.getStatus() == OrderStatus.CANCELLED))
                .sorted(Comparator.comparing(Order::getTotalValue).reversed())
                .limit(limitNumber)
                .forEach(System.out::println);

    }

    public static void isQuantityLessThanN(List<Order> orders,ProductCategory category, int quantityNumber) {
        boolean quantityLessThanN = orders.stream()
                .filter(order -> order.getProductCategory() == category)
                .allMatch(order -> order.getQuantity() < quantityNumber);
        System.out.println("\nQuantity less than " + quantityNumber + ": " + quantityLessThanN);
    }

    public static Set<String> showCustomerName(){
        return orders.stream()
                .map(Order::getCustomerName)
                .collect(Collectors.toSet());
    }

    public static void showStatus() {
        for (OrderStatus status : OrderStatus.values()) {
            System.out.println("- " + status);
        }
    }

    public static void showCategories(){
            for (ProductCategory category : ProductCategory.values()) {
                System.out.println("- " + category);
        }
    }

    public static List<Order> getOrders() {
        return orders;
    }
}

