package co.com.quind.logitrack.infrastructure.entrypoints.apirest.mapper;

import co.com.quind.logitrack.domain.model.Package;
import co.com.quind.logitrack.domain.model.PackageState;
import co.com.quind.logitrack.domain.model.vo.PackageStatus;
import co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.request.PackageRequest;
import co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.response.PackageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PackageRestMapper {

    Package toModel(PackageRequest packageRequest);

    @Mapping(target = "currentStatus", source = "statusHistory", qualifiedByName = "getLastStatus")
    PackageResponse toResponse(Package packageResult);

    @Named("getLastStatus")
    default PackageState getLastStatus(final List<PackageStatus> history) {

        if (history == null || history.isEmpty()) {
            return null;
        }

        return history.getLast().status();
    }
}