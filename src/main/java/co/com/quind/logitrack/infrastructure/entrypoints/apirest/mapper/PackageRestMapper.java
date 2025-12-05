package co.com.quind.logitrack.infrastructure.entrypoints.apirest.mapper;

import co.com.quind.logitrack.domain.model.Package;
import co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.request.PackageRequest;
import co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.response.PackageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PackageRestMapper {

    Package toModel(PackageRequest packageRequest);

    PackageResponse toResponse(Package packageResult);
}