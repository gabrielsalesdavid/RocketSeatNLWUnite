package rocketseat.com.pass.in.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.pass.in.repositories.EventRepository;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public void getEventDetail (String eventId) {

        this.eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found with ID:" + eventId));

        return;
    }
}