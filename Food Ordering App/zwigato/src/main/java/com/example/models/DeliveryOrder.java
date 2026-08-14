package com.example.models;

import com.example.strategies.*;
import java.util.List;

public class DeliveryOrder extends Order {
    private String userAddress;
    public DeliveryOrder() {
        super();
    }
    
    public DeliveryOrder(User user, Restaurant restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy, String scheduled) {
        super();
        this.setUser(user);
        this.setRestaurant(restaurant);
        this.setItems(items);
        this.setPaymentStrategy(paymentStrategy);
        this.setScheduled(scheduled);
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserAddress() {
        return userAddress;
    }

    @Override
    public String getType() {
        return "Delivery";
    }
}
