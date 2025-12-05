package co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.entities;

import co.com.quind.logitrack.domain.model.DeliveryAddress;
import co.com.quind.logitrack.domain.model.vo.Dimensions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "packages")
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tracking_id", nullable = false, unique = true)
    private String trackingId;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "delivery_address", columnDefinition = "jsonb")
    private DeliveryAddress address;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "dimensions", nullable = false, columnDefinition = "jsonb")
    private Dimensions dimensions;

    @OneToMany(mappedBy = "packageHistory", fetch = FetchType.EAGER)
    @OrderBy("timestamp ASC")
    private List<PackageStatusEntity> statusHistory;

    @OneToMany(mappedBy = "packageLocation", fetch = FetchType.EAGER)
    @OrderBy("timestamp ASC")
    private List<LocationEntity> locations;

}