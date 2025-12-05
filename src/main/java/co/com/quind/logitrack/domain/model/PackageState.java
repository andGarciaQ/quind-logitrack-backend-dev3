package co.com.quind.logitrack.domain.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PackageState {
    CREATED,
    IN_TRANSIT,
    OUT_FOR_DELIVERY,
    DELIVERY_FAILED,
    DELIVERED,
    RETURNED;
}
