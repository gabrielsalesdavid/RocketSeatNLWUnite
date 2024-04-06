package rocketseat.com.pass.in.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.com.pass.in.domain.checkin.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Integer> {
}