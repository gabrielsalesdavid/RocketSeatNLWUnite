package rocketseat.com.pass.in.repositories;

import rocketseat.com.pass.in.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {

}