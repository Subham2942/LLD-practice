package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int restaurantCounter = 0;
    private final int restaurantId;
    private final String restaurantName;
    private final String restaurantAddress;
    private List<MenuItem> menu = new ArrayList<>();

    public Restaurant(String restaurantName, String restaurantAddress) {
        this.restaurantId = ++restaurantCounter;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addMenuItem(MenuItem item) {
        this.menu.add(item);
    }

}
