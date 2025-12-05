package co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.request;

public record AddressRequest(
        String name,
        String cityName,
        String countryName,
        String address,
        String neighborhood) { }
