package rocketseat.com.pass.in.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rocketseat.com.pass.in.dto.event.EventIdDTO;
import rocketseat.com.pass.in.dto.event.EventRequestDTO;
import rocketseat.com.pass.in.dto.event.EventResponseDTO;
import rocketseat.com.pass.in.services.EventService;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService service;

    @GetMapping("/{eventId}")
    public ResponseEntity <EventResponseDTO> getEvent (@PathVariable String eventId) {

        EventResponseDTO event = this.service.getEventDetail(eventId);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventIdDTO> createEvent (@RequestBody EventRequestDTO body,
                                                   UriComponentsBuilder uriComponentsBuilder) {

        EventIdDTO eventIdDTO = this.service.creatEvent(body);

        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(eventIdDTO.eventId()).toUri();

        return ResponseEntity.created(uri).body(eventIdDTO);
    }
}