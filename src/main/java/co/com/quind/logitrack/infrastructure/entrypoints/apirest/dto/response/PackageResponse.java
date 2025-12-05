package co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.response;

import co.com.quind.logitrack.domain.model.PackageState;

public record PackageResponse(
        String trackingId,
        FullAddressResponse address,
        DimensionResponse dimensions,
        PackageState currentStatus) {
}
