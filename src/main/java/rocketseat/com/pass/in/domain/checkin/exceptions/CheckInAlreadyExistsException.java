package rocketseat.com.pass.in.domain.checkin.exceptions;

public class CheckInAlreadyExistsException extends RuntimeException {

    public CheckInAlreadyExistsException(String message) {

        super(message);
    }
}