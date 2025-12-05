package co.com.quind.logitrack.domain.model;

import co.com.quind.logitrack.domain.exception.DataRequiredException;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DeliveryAddress {

    private String name;
    private String cityName;
    private String departmentName;
    private String address;
    private String neighborhood;

    public void validateRequiredData() {
        if (name == null) {
            throw new DataRequiredException("name");
        }
        if (cityName == null || cityName.isBlank()) {
            throw new DataRequiredException("cityName");
        }
        if (departmentName == null || departmentName.isBlank()) {
            throw new DataRequiredException("departmentName");
        }
        if (address == null || address.isBlank()) {
            throw new DataRequiredException("address");
        }
        if (neighborhood == null || neighborhood.isBlank()) {
            throw new DataRequiredException("neighborhood");
        }
    }
}
