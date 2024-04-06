package rocketseat.com.pass.in.config;

import jdk.jshell.EvalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rocketseat.com.pass.in.domain.event.exceptions.EventNotFoundException;

@ControllerAdvice
public class ExceptionEntityHandler {

    @ExceptionHandler(EvalException.class)
    public ResponseEntity handlerEventNotFound (EventNotFoundException exception) {

        return ResponseEntity.notFound().build();
    }
}
