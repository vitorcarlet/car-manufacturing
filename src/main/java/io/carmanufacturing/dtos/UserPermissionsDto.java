package io.carmanufacturing.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public record UserPermissionsDto (
        boolean isAdmin,
        boolean isOperator,
        boolean isAssistant
) {
}
