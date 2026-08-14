package com.shipping.strategy;

import com.shipping.model.Order;

public class ExpressShipping implements ShippingStrategy {
    @Override
    public int calculateShippingCost(Order order) {
        return order.getWeightInKG() * 5 + 20;
    }
}
