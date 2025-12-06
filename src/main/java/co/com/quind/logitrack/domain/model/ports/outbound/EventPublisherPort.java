package co.com.quind.logitrack.domain.model.ports.outbound;

public interface EventPublisherPort {

    void publishEvent(Object event, String key, String topic);
}

