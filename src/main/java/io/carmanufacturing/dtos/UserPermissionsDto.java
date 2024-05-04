package io.carmanufacturing.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public record UserPermissionsDto (
        boolean isAdmin,
        boolean isOperator,
        boolean isAssistant
) {
}
