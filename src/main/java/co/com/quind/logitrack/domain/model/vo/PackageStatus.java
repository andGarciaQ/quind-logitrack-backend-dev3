package co.com.quind.logitrack.domain.model.vo;

import co.com.quind.logitrack.domain.model.PackageState;

import java.time.OffsetDateTime;
import java.util.Objects;

public record PackageStatus(PackageState status, OffsetDateTime timestamp) {

    public PackageStatus {
        Objects.requireNonNull(timestamp, "Timestamp cannot be null");
    }

    public static PackageStatus registerPackageStatus(PackageState status) {
        return new PackageStatus(status, OffsetDateTime.now());
    }
}
