package io.carmanufacturing.entities;

public record UserPermissions (
        String name,
        boolean isAdmin,
        boolean isOperator,
        boolean isAssistant
){
}
