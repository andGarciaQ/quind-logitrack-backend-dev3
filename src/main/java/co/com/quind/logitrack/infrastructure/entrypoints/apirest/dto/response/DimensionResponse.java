package co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.response;

public record DimensionResponse(
        double width,
        double height,
        double depth,
        double weight) {}