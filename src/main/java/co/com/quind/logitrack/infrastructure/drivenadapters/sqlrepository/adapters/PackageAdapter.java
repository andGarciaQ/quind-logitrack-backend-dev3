package co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.adapters;

import co.com.quind.logitrack.domain.model.Package;
import co.com.quind.logitrack.domain.model.ports.outbound.PackageRepository;
import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.entities.LocationEntity;
import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.entities.PackageEntity;
import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.entities.PackageStatusEntity;
import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.mappers.PackageMapper;
import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.repositories.LocationJpaRepository;
import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.repositories.PackageJpaRepository;
import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.repositories.PackageStatusJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PackageAdapter implements PackageRepository {

    private final PackageJpaRepository packageJpaRepository;
    private final LocationJpaRepository locationJpaRepository;
    private final PackageStatusJpaRepository packageStatusJpaRepository;

    private final PackageMapper packageMapper;

    @Override
    @Transactional
    public Package save(final Package packageToSave) {

        final PackageEntity packageEntity = packageMapper.toEntity(packageToSave);
        final PackageEntity packageSaved = packageJpaRepository.saveAndFlush(packageEntity);
        log.debug("packageSaved={}", packageEntity);

        final List<PackageStatusEntity> statusHistory = packageStatusJpaRepository.saveAllAndFlush(
                packageMapper.toStatusEntities(packageToSave.getStatusHistory(), packageSaved)
        );
        log.debug("statusHistory={}", statusHistory);

        final List<LocationEntity> locations = locationJpaRepository.saveAllAndFlush(
                packageMapper.toLocationEntities(packageToSave.getLocations(), packageSaved)
        );
        log.debug("locations={}", locations);

        return packageMapper.joinToDomain(packageSaved, locations, statusHistory);
    }
}
