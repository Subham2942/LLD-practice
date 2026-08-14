package com.shipping.strategy;

import com.shipping.model.Order;

public class PickUp implements ShippingStrategy {
    @Override
    public int calculateShippingCost(Order order) {
        return 0;
    }
}
