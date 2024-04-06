package rocketseat.com.pass.in.controllers;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import rocketseat.com.pass.in.dto.attendee.AttendeeBadgeResponseDTO;
import rocketseat.com.pass.in.services.AttendeeService;

@RestController
@RequestMapping("/attendees")
@RequiredArgsConstructor
public class AttendeeController {

    private final AttendeeService attendeeService;

    @RequestMapping("/{attendeeId}/badge")
    public ResponseEntity <AttendeeBadgeResponseDTO> getAttendeeBadge(@PathVariable String attendeeId,
                                                    UriComponentsBuilder uriComponentsBuilder) {

        AttendeeBadgeResponseDTO response = this.attendeeService.getAttendeeBadge(attendeeId, uriComponentsBuilder);
        return ResponseEntity.ok(response);
    }
}