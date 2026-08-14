package com.shipping.strategy;

import com.shipping.model.Order;

public class StandardShipping implements ShippingStrategy {
    @Override
    public int calculateShippingCost(Order order) {
        return order.getWeightInKG() * 3 + 12;
    }
}
