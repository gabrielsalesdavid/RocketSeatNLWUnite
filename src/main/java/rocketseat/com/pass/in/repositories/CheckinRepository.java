package rocketseat.com.pass.in.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.com.pass.in.checkin.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Integer> {
}