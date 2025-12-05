package co.com.quind.logitrack.infrastructure.entrypoints.apirest.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;

public record ErrorResponse(
        @Schema(example = "400", description = "Codigo del error")
        String code,
        @Schema(example = "BAD_REQUEST", description = "Descripción del error")
        String message) {
}
