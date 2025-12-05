package co.com.quind.logitrack.domain.model;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OutboxEvent {

    private Long id;
    private String aggregateType;
    private String aggregateId;
    private String eventType;
    private String topic;
    private String payload;
    private String status; // PENDING, SENT, FAILED
    private Integer retryCount;
    private String errorMessage;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}

