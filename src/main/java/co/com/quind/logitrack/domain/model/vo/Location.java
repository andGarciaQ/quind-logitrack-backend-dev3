package co.com.quind.logitrack.domain.model.vo;

import java.time.OffsetDateTime;
import java.util.Objects;

public record Location(String city, String country, OffsetDateTime timestamp) {

    public Location {

        Objects.requireNonNull(timestamp, "Timestamp cannot be null");

        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be empty");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country cannot be empty");
        }
    }

    public static Location registerNewLocation(String city, String country) {
        return new Location(city, country, OffsetDateTime.now());
    }

}
