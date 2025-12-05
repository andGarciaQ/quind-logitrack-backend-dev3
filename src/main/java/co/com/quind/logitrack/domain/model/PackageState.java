package co.com.quind.logitrack.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PackageState {

    CREATED("Created"),
    IN_TRANSIT("In Transit"),
    OUT_FOR_DELIVERY("Out for Delivery"),
    DELIVERY_FAILED("Delivery Failed"),
    DELIVERED("Delivered"),
    RETURNED("Returned to Sender");

    private static final PackageState[] VALUES = PackageState.values();

    private final String description;

    @JsonValue
    public String valueToSerialize() {
        return description;
    }

    @JsonCreator
    public PackageState fromValue(String value) {
        for (final PackageState paymentWay : VALUES) {
            if (paymentWay.description.equals(value)) {
                return paymentWay;
            }
        }
        return null;
    }
}
