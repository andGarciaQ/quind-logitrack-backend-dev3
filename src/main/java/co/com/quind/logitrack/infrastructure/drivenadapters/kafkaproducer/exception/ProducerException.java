package co.com.quind.logitrack.infrastructure.drivenadapters.kafkaproducer.exception;

public class ProducerException extends RuntimeException {

    public ProducerException(String message, Throwable ex) {
        super(message, ex);
    }
}
