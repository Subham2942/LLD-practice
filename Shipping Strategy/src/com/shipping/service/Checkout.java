package com.shipping.service;

import java.util.Objects;

import com.shipping.model.Order;
import com.shipping.strategy.ShippingStrategy;

public class Checkout {

    private ShippingStrategy shippingStrategy;

    public Checkout(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = Objects.requireNonNull(
                shippingStrategy,
                "Shipping strategy cannot be null"
        );
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = Objects.requireNonNull(
                shippingStrategy,
                "Shipping strategy cannot be null"
        );
    }

    public int calculateShippingCost(Order order) {
        Objects.requireNonNull(order, "Order cannot be null");
        return shippingStrategy.calculateShippingCost(order);
    }
}
