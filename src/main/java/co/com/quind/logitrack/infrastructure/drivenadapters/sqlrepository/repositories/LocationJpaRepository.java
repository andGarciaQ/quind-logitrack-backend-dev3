package co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.repositories;

import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationJpaRepository extends JpaRepository<LocationEntity, Long> {

}
