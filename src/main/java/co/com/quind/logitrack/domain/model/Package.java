package co.com.quind.logitrack.domain.model;

import co.com.quind.logitrack.domain.model.vo.Dimensions;
import co.com.quind.logitrack.domain.model.vo.Location;
import co.com.quind.logitrack.domain.model.vo.PackageStatus;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Package {

    private String trackingId;
    private DeliveryAddress address;
    private Dimensions dimensions;
    private List<PackageStatus> statusHistory;
    private List<Location> locations;

    public static Package createPackageFirstTime(final Package packageModel) {

        final var deliveryAddress = packageModel.getAddress();
        deliveryAddress.validateRequiredData();

        final var firstStatus = List.of(PackageStatus.registerPackageStatus(PackageState.CREATED));
        final var firstLocation = List.of(Location.registerNewLocation(deliveryAddress.getCityName(), deliveryAddress.getCountryName()));

        return new Package(
                UUID.randomUUID().toString(),
                packageModel.address,
                packageModel.dimensions,
                firstStatus,
                firstLocation);
    }

}
