package exception;

public class UnavailableDoctorException extends RuntimeException{
    public UnavailableDoctorException(String message){
        super(message);
    }
}
