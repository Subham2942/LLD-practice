package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    Restaurant restaurant;
    private List<MenuItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Cart(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void addItem(MenuItem item) {
        this.items.add(item);
    }

    public void removeItem(MenuItem item) {
        this.items.remove(item);
    }

    public int getTotalPrice() {
        int total = 0;
        for (MenuItem item : items) {
            total += item.getItemPrice();
        }
        return total;
    }

    public boolean isEmpty() {
        return restaurant == null || items.isEmpty();
    }

    public void clearCart() {
        this.items.clear();
    }
}
