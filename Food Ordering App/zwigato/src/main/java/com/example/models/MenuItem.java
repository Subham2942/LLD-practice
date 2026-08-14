package com.example.models;

public class MenuItem {
    private final String itemId;
    private final String itemName;
    private final double itemPrice;

    public MenuItem(String itemId, String itemName, double itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

}
