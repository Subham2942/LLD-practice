package com.example;

import com.example.models.Order;
import com.example.models.Restaurant;
import com.example.models.User;
import com.example.strategies.UpiPaymentStrategy;

public class App 
{
        public static void main(String[] args) {
        // Simulating a happy flow
        // Create Zwigato Object
        Zwigato zwigato = new Zwigato();

        // Simulate a user coming in (Happy Flow)
        User user = new User(101, "Aditya", "Delhi");
        System.out.println("User: " + user.getUserName() + " is active.");

        // User searches for restaurants by location
        java.util.List<Restaurant> restaurantList = zwigato.searchRestaurants("Delhi");

        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        for (Restaurant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getRestaurantName());
        }

        // User selects a restaurant
        zwigato.selectRestaurant(user, restaurantList.get(0));
        System.out.println("Selected restaurant: " + restaurantList.get(0).getRestaurantName());

        // User adds items to the cart
        zwigato.addToCart(user, "P1");
        zwigato.addToCart(user, "P2");

        zwigato.printUserCart(user);

        // User checkout the cart
        Order order = zwigato.checkoutNow(user, "Delivery", new UpiPaymentStrategy("1234567890"));

        // User pays for the cart. If payment is successful, notification is sent.
        zwigato.payForOrder(user, order);
    }
}
