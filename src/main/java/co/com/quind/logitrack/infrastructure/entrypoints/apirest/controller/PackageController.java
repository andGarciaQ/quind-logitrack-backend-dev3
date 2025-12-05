package co.com.quind.logitrack.infrastructure.entrypoints.apirest.controller;

import co.com.quind.logitrack.domain.model.ports.inbound.PackageHandler;
import co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.request.PackageRequest;
import co.com.quind.logitrack.infrastructure.entrypoints.apirest.dto.response.PackageResponse;
import co.com.quind.logitrack.infrastructure.entrypoints.apirest.logging.Logging;
import co.com.quind.logitrack.infrastructure.entrypoints.apirest.mapper.PackageRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/packages")
@RequiredArgsConstructor
public class PackageController {

    private final PackageHandler packageHandler;
    private final PackageRestMapper packageMapper;

    @Logging
    @PostMapping
    public ResponseEntity<PackageResponse> createPackage(@Valid @RequestBody PackageRequest request) {
        final var createdPackage = packageHandler.createPackage(packageMapper.toModel(request));
        return new ResponseEntity<>(packageMapper.toResponse(createdPackage), HttpStatus.CREATED);
    }

}
