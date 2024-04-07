package rocketseat.com.pass.in.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.pass.in.domain.attendee.Attendee;
import rocketseat.com.pass.in.domain.checkin.CheckIn;
import rocketseat.com.pass.in.domain.checkin.exceptions.CheckInAlreadyExistsException;
import rocketseat.com.pass.in.repositories.CheckInRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {

    private final CheckInRepository checkInRepository;

    public void registerCheckIn (Attendee attendee) {

        this.verifyCheckInExists(attendee.getId());

        CheckIn newCheckIn = new CheckIn();
        newCheckIn.setAttendee(attendee);
        newCheckIn.setCreatedAt(LocalDateTime.now());
        this.checkInRepository.save(newCheckIn);
    }

    private void verifyCheckInExists (String attendeeId) {

        Optional<CheckIn> isCheckedIn = this.getCheckIn(attendeeId);

        if (isCheckedIn.isPresent()) throw new CheckInAlreadyExistsException("Attendee already checked in!");
    }

    public Optional<CheckIn> getCheckIn (String attendeeId) {

        return this.checkInRepository.findByAttendeeId(attendeeId);
    }
}