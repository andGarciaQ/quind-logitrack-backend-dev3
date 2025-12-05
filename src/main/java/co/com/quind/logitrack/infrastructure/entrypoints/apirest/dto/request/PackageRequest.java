package co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record PackageRequest(

        @NotNull(message = "Full Address is required")
        @Valid
        FullAddressRequest address,

        @NotNull(message = "Dimensions are required")
        DimensionRequest dimensions
) {}