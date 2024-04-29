package io.carmanufacturing.entities;

public record Permissions(
        String name,
        boolean isAdmin,
        boolean isOperator,
        boolean isAssistant
) {
}
