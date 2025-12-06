package co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.mappers;

import co.com.quind.logitrack.domain.model.OutboxEvent;
import co.com.quind.logitrack.infrastructure.drivenadapters.sqlrepository.entities.OutboxEventEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OutboxEventMapper {

    OutboxEvent toDomain(OutboxEventEntity outboxEventEntity);
}
