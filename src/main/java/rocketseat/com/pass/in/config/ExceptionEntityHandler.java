package rocketseat.com.pass.in.config;

import jdk.jshell.EvalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rocketseat.com.pass.in.domain.attendee.exceptions.AttendeeAlreadyExistException;
import rocketseat.com.pass.in.domain.attendee.exceptions.AttendeeNotFoundException;
import rocketseat.com.pass.in.domain.checkin.exceptions.CheckInAlreadyExistsException;
import rocketseat.com.pass.in.domain.event.exceptions.EventFullException;
import rocketseat.com.pass.in.domain.event.exceptions.EventNotFoundException;
import rocketseat.com.pass.in.dto.general.ErrorResponseDTO;

@ControllerAdvice
public class ExceptionEntityHandler {

    @ExceptionHandler(EvalException.class)
    public ResponseEntity handlerEventNotFound (EventNotFoundException exception) {

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EventFullException.class)
    public ResponseEntity<ErrorResponseDTO> handlerEventFullException (EventFullException exception) {

        return ResponseEntity.badRequest().body(new ErrorResponseDTO(exception.getMessage()));
    }

    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity handlerAttendeeNotFoundException (AttendeeNotFoundException exception) {

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeAlreadyExistException.class)
    public ResponseEntity handlerAttendeeAlreadyExistException (AttendeeAlreadyExistException exception) {

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(CheckInAlreadyExistsException.class)
    public ResponseEntity handlerCheckInAlreadyExistsException (CheckInAlreadyExistsException exception) {

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
