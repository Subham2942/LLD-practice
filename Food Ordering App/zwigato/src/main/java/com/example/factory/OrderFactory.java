package com.example.factory;
import com.example.models.*;
import com.example.strategies.*;
import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy, double totalCost, String orderType);
}