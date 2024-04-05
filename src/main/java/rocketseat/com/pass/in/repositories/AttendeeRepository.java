package rocketseat.com.pass.in.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.com.pass.in.domain.attendee.Attendee;

public interface AttendeeRepository extends JpaRepository <Attendee, String> {
}
