package rocketseat.com.pass.in.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rocketseat.com.pass.in.dto.attendee.AttendeesListResponseDTO;
import rocketseat.com.pass.in.dto.event.EventIdDTO;
import rocketseat.com.pass.in.dto.event.EventRequestDTO;
import rocketseat.com.pass.in.dto.event.EventResponseDTO;
import rocketseat.com.pass.in.services.AttendeeService;
import rocketseat.com.pass.in.services.EventService;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final AttendeeService attendeeService;

    @GetMapping("/{eventId}")
    public ResponseEntity <EventResponseDTO> getEvent (@PathVariable String eventId) {

        EventResponseDTO event = this.eventService.getEventDetail(eventId);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventIdDTO> createEvent (@RequestBody EventRequestDTO body,
                                                   UriComponentsBuilder uriComponentsBuilder) {

        EventIdDTO eventIdDTO = this.eventService.creatEvent(body);

        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(eventIdDTO.eventId()).toUri();

        return ResponseEntity.created(uri).body(eventIdDTO);
    }

    @GetMapping("/attendees/{Id}")
    public ResponseEntity <AttendeesListResponseDTO> getEventAttendees (@PathVariable String id) {

        AttendeesListResponseDTO attendeesListResponse = this.attendeeService.getEventsAttendee(id);
        return ResponseEntity.ok(attendeesListResponse);
    }
}