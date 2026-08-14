package com.example.services;

import com.example.models.*;
import java.util.List;

public class NotificationService {
    private NotificationService() {
        // Private constructor to prevent instantiation
    }
    public static void notify(Order order) {
        System.out.println("\nNotification: New " + order.getType() + " order placed!");
        System.out.println("---------------------------------------------");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getUser().getUserName());
        System.out.println("Restaurant: " + order.getRestaurant().getRestaurantName());
        System.out.println("Items Ordered:");

        List<MenuItem> items = order.getItems();
        for (MenuItem item : items) {
            System.out.println("   - " + item.getItemName() + " (₹" + item.getItemPrice() + ")");
        }

        System.out.println("Total: ₹" + order.getTotal());
        System.out.println("Scheduled For: " + order.getScheduled());
        System.out.println("Payment: Done");
        System.out.println("---------------------------------------------");
    }
}