package co.com.quind.logitrack.domain.exception;

import lombok.Getter;

@Getter
public class DataRequiredException extends IllegalArgumentException {

    public static final String MESSAGE_DATA_NULL = "Null data error in event when processing the message";

    public DataRequiredException(String attributeName) {
        super("The attribute '" + attributeName + "' is required");
    }
}
