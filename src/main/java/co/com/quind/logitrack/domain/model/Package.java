package co.com.quind.logitrack.domain.model;

import co.com.quind.logitrack.domain.model.vo.Dimensions;
import co.com.quind.logitrack.domain.model.vo.Location;
import co.com.quind.logitrack.domain.model.vo.PackageStatus;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Package {

    private String trackingId;
    private DeliveryAddress deliveryAddress;
    private Dimensions dimensions;
    private List<PackageStatus> statusHistory;
    private List<Location> locations;

}
