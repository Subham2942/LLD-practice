package com.example.models;

public class User {

    private int userId;
    private String userName;
    private String address;
    private Cart cart;

    public User(int userId, String userName, String address) {
        this.userId = userId;
        this.userName = userName;
        this.address = address;

        this.cart = new Cart();
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAddress() {
        return address;
    }

    public Cart getCart() {
        return cart;
    }
}
