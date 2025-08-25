package co.com.bancolombia.api.exception;

public class InvalidApplicantDataException extends RuntimeException {
    public InvalidApplicantDataException(String message) {
        super(message);
    }
}