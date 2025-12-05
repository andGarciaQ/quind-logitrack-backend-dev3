package co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.mappers;

import co.com.quind.logitrack.domain.model.Package;
import co.com.quind.logitrack.domain.model.vo.Location;
import co.com.quind.logitrack.domain.model.vo.PackageStatus;
import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.entities.LocationEntity;
import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.entities.PackageEntity;
import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.entities.PackageStatusEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PackageMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "locations", ignore = true)
    @Mapping(target = "statusHistory", ignore = true)
    PackageEntity toEntity(Package domain);

    List<LocationEntity> toLocationEntities(final List<Location> logs, @Context PackageEntity parent);

    List<PackageStatusEntity> toStatusEntities(final List<PackageStatus> logs, @Context PackageEntity parent);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "packageLocation", expression = "java(parent)")
    LocationEntity toLocationEntity(final Location location, @Context final PackageEntity parent);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "packageHistory", expression = "java(parent)")
    PackageStatusEntity toStatusEntity(final PackageStatus log, @Context final PackageEntity parent);

    @Mapping(target = "trackingId", source = "entity.trackingId")
    @Mapping(target = "address", source = "entity.address")
    @Mapping(target = "dimensions", source = "entity.dimensions")
    @Mapping(target = "locations", source = "locations")
    @Mapping(target = "statusHistory", source = "statusHistory")
    Package joinToDomain(final PackageEntity entity, List<LocationEntity> locations, List<PackageStatusEntity> statusHistory);
}