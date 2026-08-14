package com.shipping.model;

public class Order {
    private final String orderId;
    private final String customerId;
    private final int weightInKG;

    public Order(String orderId, String customerId, int weightInKG) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.weightInKG = weightInKG;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getWeightInKG() {
        return weightInKG;
    }
}
