package exception;

public class UnregisteredDoctorException extends RuntimeException {
    public UnregisteredDoctorException(String message) {
        super(message);
    }
}
