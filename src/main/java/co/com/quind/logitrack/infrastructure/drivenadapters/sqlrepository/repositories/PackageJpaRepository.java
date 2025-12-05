package co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.repositories;

import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.entities.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageJpaRepository extends JpaRepository<PackageEntity, Long> {

}