package rocketseat.com.pass.in.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    public ResponseEntity <String> getTest () {
        return ResponseEntity.ok("sucesso!");
    }
}