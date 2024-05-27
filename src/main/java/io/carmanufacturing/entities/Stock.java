package io.carmanufacturing.entities;

public record Stock(
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

}
