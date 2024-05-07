package io.carmanufacturing.dtos;





public record UserPermissionsDto (
        boolean isAdmin,
        boolean isOperator,
        boolean isAssistant
) {
    @Override
    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public boolean isOperator() {
        return isOperator;
    }

    @Override
    public boolean isAssistant() {
        return isAssistant;
    }
}
