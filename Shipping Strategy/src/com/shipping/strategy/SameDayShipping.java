package com.shipping.strategy;

import com.shipping.model.Order;

public class SameDayShipping implements ShippingStrategy {
    @Override
    public int calculateShippingCost(Order order) {
        return order.getWeightInKG() * 10 + 50;
    }
}
