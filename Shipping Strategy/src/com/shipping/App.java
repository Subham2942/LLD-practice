package com.shipping;

import com.shipping.model.Order;
import com.shipping.service.Checkout;
import com.shipping.strategy.ShippingStrategy;
import com.shipping.strategy.ShippingStrategyFactory;
import com.shipping.strategy.ShippingType;

public class App {

    public static void main(String[] args) {
        Order order1 = new Order("O001", "C001", 10);
        Order order2 = new Order("O002", "C002", 5);

        ShippingStrategy expressShipping
                = ShippingStrategyFactory.create(ShippingType.EXPRESS);
        Checkout checkout = new Checkout(expressShipping);

        System.out.println("Express Shipping Cost for Order 1: "
                + checkout.calculateShippingCost(order1));

        checkout.setShippingStrategy(
                ShippingStrategyFactory.create(ShippingType.SAME_DAY));
        System.out.println("Same Day Shipping Cost for Order 2: "
                + checkout.calculateShippingCost(order2));

        checkout.setShippingStrategy(
                ShippingStrategyFactory.create(ShippingType.PICKUP));
        System.out.println("Pick Up Cost for Order 1: "
                + checkout.calculateShippingCost(order1));

        checkout.setShippingStrategy(
                ShippingStrategyFactory.create(ShippingType.STANDARD));
        System.out.println("Standard Shipping Cost for Order 2: "
                + checkout.calculateShippingCost(order2));
    }
}
