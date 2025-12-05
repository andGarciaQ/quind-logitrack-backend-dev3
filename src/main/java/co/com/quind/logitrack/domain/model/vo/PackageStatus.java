package co.com.quind.logitrack.domain.model.vo;

import java.time.OffsetDateTime;
import java.util.Objects;

public record PackageStatus(PackageStatus status, OffsetDateTime timestamp) {

    public PackageStatus {
        Objects.requireNonNull(status, "Status cannot be null");
        Objects.requireNonNull(timestamp, "Timestamp cannot be null");
    }

    public static PackageStatus registerPackageStatus(PackageStatus status) {
        return new PackageStatus(status, OffsetDateTime.now());
    }
}
