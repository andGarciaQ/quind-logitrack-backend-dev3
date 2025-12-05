package co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.request;

public record FullAddressRequest(
        String name,
        String cityName,
        String departmentName,
        String address,
        String neighborhood) { }
