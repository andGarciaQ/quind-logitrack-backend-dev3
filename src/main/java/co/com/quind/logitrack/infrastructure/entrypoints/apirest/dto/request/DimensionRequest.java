package co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.request;

public record DimensionRequest(
        double width,
        double height,
        double depth,
        double weight) {}