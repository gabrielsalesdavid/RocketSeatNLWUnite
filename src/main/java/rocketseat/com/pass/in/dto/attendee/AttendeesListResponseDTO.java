package rocketseat.com.pass.in.dto.attendee;

import lombok.Getter;

import java.util.List;

public record AttendeesListResponseDTO (List<AttendeeDetails> attendees) {
}