package rocketseat.com.pass.in.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.com.pass.in.domain.attendee.Attendee;

import java.util.List;
import java.util.Optional;

public interface AttendeeRepository extends JpaRepository <Attendee, String> {

    List<Attendee> findByEventId(String EventId);

    Optional<Attendee> findByEventIdAndEmail (String eventId, String email);
}