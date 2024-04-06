package rocketseat.com.pass.in.domain.attendee.exceptions;

public class AttendeeAlreadyExistException extends RuntimeException {

    public AttendeeAlreadyExistException (String message) {

        super(message);
    }
}