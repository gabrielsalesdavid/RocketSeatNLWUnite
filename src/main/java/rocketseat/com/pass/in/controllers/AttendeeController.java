package rocketseat.com.pass.in.controllers;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendees")
public class AttendeeController {

    @RequestMapping
    public ResponseEntity <String> getTest() {
        return ResponseEntity.ok("sucesso!");
    }
}
