package edu.baylor.ecs.qms.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InstanceCreatingException extends RuntimeException {
    public InstanceCreatingException(String message) {
        super(message);
    }

    public InstanceCreatingException(String message, Throwable cause) {
        super(message, cause);
    }
}
