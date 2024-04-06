package rocketseat.com.pass.in.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.com.pass.in.domain.checkin.CheckIn;

import java.util.Optional;

public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {

    Optional<CheckIn> findByAttendeeId (String attendeeId);
}