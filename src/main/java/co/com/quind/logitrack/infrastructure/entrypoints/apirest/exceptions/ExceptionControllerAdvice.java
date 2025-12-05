package co.com.quind.logitrack.infrastructure.entrypoints.apirest.exceptions;

import co.com.quind.logitrack.domain.exception.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.MissingRequestValueException;
import org.springframework.web.server.ServerWebInputException;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        log.info("ERROR general ExceptionClass: {}", ex.getClass());
        log.error("ERROR general: ", ex);
        return ResponseEntity.internalServerError()
                .body(new ErrorResponse(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.name()));
    }

    @ExceptionHandler({
            NoResourceFoundException.class,
            ServerWebInputException.class,
            UnsupportedMediaTypeStatusException.class,
            MissingServletRequestParameterException.class,
    })
    public ResponseEntity<ErrorResponse> handleExceptionNoResourceFound(Exception ex) {
        log.info("ERROR on API ExceptionClass: {}", ex.getClass());
        log.error("ERROR on API: ", ex);
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.name()));
    }

    @ExceptionHandler({
            IllegalArgumentException.class,
            MissingRequestValueException.class,
            MethodArgumentTypeMismatchException.class
    })
    public ResponseEntity<ErrorResponse> handleBadRequestException(RuntimeException ex) {
        log.info("ERROR RuntimeException ExceptionClass: {}", ex.getClass());
        log.error("ERROR Validations: ", ex);
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), ex.getMessage()));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoHandlerFound(NoHandlerFoundException ex) {
        log.error("ERROR NoHandlerFoundException:", ex);
        return new ResponseEntity<>(new ErrorResponse(
                String.valueOf(HttpStatus.NOT_FOUND.value()),
                "La ruta solicitada no existe. Verifique el método HTTP y la URL."
        ), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException ex) {
        log.error("ERROR on API DataNotFoundException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(String.valueOf(HttpStatus.NOT_FOUND.value()), ex.getMessage()));
    }

}
