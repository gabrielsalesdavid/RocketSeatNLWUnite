package rocketseat.com.pass.in.domain.event.exceptions;

public class EventFullException extends  RuntimeException {

    public EventFullException (String message) {

        super(message);
    }
}