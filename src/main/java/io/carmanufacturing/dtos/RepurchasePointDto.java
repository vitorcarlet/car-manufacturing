package io.carmanufacturing.dtos;

import io.carmanufacturing.entities.Adress;

public record RepurchasePointDto (
        Long id,
        Adress adress
){
    @Override
    public Long id() {
        return id;
    }

    @Override
    public Adress adress() {
        return adress;
    }
}
