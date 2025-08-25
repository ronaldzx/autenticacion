package co.com.bancolombia.model.applicant.exception;

import lombok.Getter;

@Getter
public class EmailAlreadyExistsException extends RuntimeException {

    private final String message;

    public EmailAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

}