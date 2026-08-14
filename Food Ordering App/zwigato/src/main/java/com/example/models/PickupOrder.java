package com.example.models;
import com.example.strategies.*;
import java.util.List;

public class PickupOrder extends Order {
    private String restaurantAddress;
    public PickupOrder() {
        super();
    }

    public PickupOrder(User user, Restaurant restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy, String scheduled) {
        super();
        this.setUser(user);
        this.setRestaurant(restaurant);
        this.setItems(items);
        this.setPaymentStrategy(paymentStrategy);
        this.setScheduled(scheduled);
        this.restaurantAddress = restaurant.getRestaurantAddress();
    }

   

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    @Override
    public String getType() {
        return "Pickup";
    }
    
    
}
