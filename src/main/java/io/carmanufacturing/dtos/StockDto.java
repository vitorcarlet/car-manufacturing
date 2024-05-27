package io.carmanufacturing.dtos;

import io.carmanufacturing.entities.RepurchasePoint;

public record StockDto(
        Long id,
        String name,
        String category,
        float averageCost,
        float stockValue,
        float stockQuantity,
        float expectedStock,
        float commitedStock,
        RepurchasePoint repurchasePoint

) {

    @Override
    public Long id() {
        return id;
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
    public float averageCost() {
        return averageCost;
    }

    @Override
    public float stockValue() {
        return stockValue;
    }

    @Override
    public float stockQuantity() {
        return stockQuantity;
    }

    @Override
    public float expectedStock() {
        return expectedStock;
    }

    @Override
    public float commitedStock() {
        return commitedStock;
    }

    @Override
    public RepurchasePoint repurchasePoint() {
        return repurchasePoint;
    }
}
