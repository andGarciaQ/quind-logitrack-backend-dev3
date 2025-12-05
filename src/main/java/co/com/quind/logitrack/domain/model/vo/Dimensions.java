package co.com.quind.logitrack.domain.model.vo;

public record Dimensions(double width, double height, double depth, double weight) {

    public Dimensions {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than zero.");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        if (depth <= 0) {
            throw new IllegalArgumentException("Depth must be greater than zero.");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero.");
        }
    }
}