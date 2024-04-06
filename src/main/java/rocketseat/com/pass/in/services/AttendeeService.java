package rocketseat.com.pass.in.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import rocketseat.com.pass.in.domain.attendee.Attendee;
import rocketseat.com.pass.in.domain.attendee.exceptions.AttendeeAlreadyExistException;
import rocketseat.com.pass.in.domain.attendee.exceptions.AttendeeNotFoundException;
import rocketseat.com.pass.in.domain.checkin.CheckIn;
import rocketseat.com.pass.in.dto.attendee.AttendeeBadgeResponseDTO;
import rocketseat.com.pass.in.dto.attendee.AttendeeDetails;
import rocketseat.com.pass.in.dto.attendee.AttendeesListResponseDTO;
import rocketseat.com.pass.in.dto.attendee.AttendeeBadgeDTO;
import rocketseat.com.pass.in.repositories.AttendeeRepository;
import rocketseat.com.pass.in.repositories.CheckInRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendeeService {

    private final AttendeeRepository attendeeRepository;
    private final CheckInRepository checkInRepository;

    public List<Attendee> getAllAttendeesFromEvent (String eventId) {

        return this.attendeeRepository.findByEventId(eventId);
    }

    public AttendeesListResponseDTO getEventsAttendee (String eventId) {

        List<Attendee> attendeeList = this.getAllAttendeesFromEvent(eventId);

        List<AttendeeDetails> attendeeDetailsList = attendeeList.stream().map(attendee -> {
            Optional <CheckIn> checkIn = this.checkInRepository.findByAttendeeId(attendee.getId());
            LocalDateTime checkedInAt = checkIn.<LocalDateTime>map(CheckIn::getCreatedAt).orElse(null);
            return new AttendeeDetails(attendee.getId(), attendee.getName(), attendee.getEmail(),
                    attendee.getCreatedAt(), checkedInAt);
        }).toList();

        return new AttendeesListResponseDTO(attendeeDetailsList);
    }

    public void verifyAttendeeSubscription(String email, String eventId) {
        Optional <Attendee> isAttendeeRegistered = this.attendeeRepository.findByEventIdAndEmail(eventId, email);

        if (isAttendeeRegistered.isPresent()) throw new AttendeeAlreadyExistException("Attendee is already registered");
    }

    public Attendee registerAttendee(Attendee newAttendee) {
        this.attendeeRepository.save(newAttendee);
        return newAttendee;
    }

    public AttendeeBadgeResponseDTO getAttendeeBadge (String attendeeId, UriComponentsBuilder uriComponentsBuilder) {

        Attendee attendee = this.attendeeRepository.findById(attendeeId).orElseThrow(() ->
                new AttendeeNotFoundException("attendee not found with ID:" + attendeeId));

        var uri = uriComponentsBuilder.path("/attendees/{attendeeId}/check-in").buildAndExpand(attendeeId).
                toUri().toString();

        AttendeeBadgeDTO badgeDTO = new AttendeeBadgeDTO(attendee.getName(), attendee.getEmail(), uri,
                attendee.getEvent().getId());

        return new AttendeeBadgeResponseDTO(badgeDTO);
    }
}