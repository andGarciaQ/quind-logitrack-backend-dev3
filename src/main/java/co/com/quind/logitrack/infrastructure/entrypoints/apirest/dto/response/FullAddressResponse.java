package co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.response;

public record FullAddressResponse(
        String name,
        String cityName,
        String countryName,
        String address,
        String neighborhood) { }
