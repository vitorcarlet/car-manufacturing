package io.carmanufacturing.entities;

import java.util.Date;

public record StockPurchase(
        Long id,
        Date purchaseDate,
        String name,
        String category,
        float cost,
        float quantity,
        RepurchasePoint repurchasePoint
) {
    @Override
    public Long id() {
        return id;
    }

    @Override
    public Date purchaseDate() {
        return purchaseDate;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String category() {
        return category;
    }

    @Override
    public float cost() {
        return cost;
    }

    @Override
    public float quantity() {
        return quantity;
    }

    @Override
    public RepurchasePoint repurchasePoint() {
        return repurchasePoint;
    }
}
