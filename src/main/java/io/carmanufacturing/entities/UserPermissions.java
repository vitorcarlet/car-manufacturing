package io.carmanufacturing.entities;

public record UserPermissions (
        boolean isAdmin,
        boolean isOperator,
        boolean isAssistant
){
}
