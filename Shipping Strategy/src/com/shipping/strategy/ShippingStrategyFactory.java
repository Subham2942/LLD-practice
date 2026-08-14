package com.shipping.strategy;

public class ShippingStrategyFactory {

    public static ShippingStrategy create(ShippingType type) {
        return switch (type) {
            case STANDARD ->
                new StandardShipping();
            case EXPRESS ->
                new ExpressShipping();
            case SAME_DAY ->
                new SameDayShipping();
            case PICKUP ->
                new PickUp();
        };
    }
}
