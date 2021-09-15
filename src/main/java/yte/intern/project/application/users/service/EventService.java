package yte.intern.project.application.users.service;

import org.springframework.stereotype.Service;
import yte.intern.project.application.common.infomessage.MessageResponse;
import yte.intern.project.application.common.infomessage.MessageType;
import yte.intern.project.application.users.entity.Event;
import yte.intern.project.application.users.repository.EventRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional
    public MessageResponse addEvent(Event event) {
        eventRepository.save(event);
        return new MessageResponse("Event is added to system successfully!", MessageType.SUCCESS);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Transactional
    public MessageResponse updateEvent(Long id, Event newEvent) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(("This event (id: %s) is not found".formatted(id))));
        event.updateEvent(newEvent);
        eventRepository.save(event);
        return new MessageResponse("Event information is updated successfully!", MessageType.SUCCESS);
    }

    public MessageResponse deleteEvent(Long id) {
        eventRepository.deleteById(id);
        return new MessageResponse("Event is deleted successfully!", MessageType.SUCCESS);
    }
}
