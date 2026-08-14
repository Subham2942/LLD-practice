package com.shipping.strategy;

import com.shipping.model.Order;

public interface ShippingStrategy {
    int calculateShippingCost(Order order);
}
