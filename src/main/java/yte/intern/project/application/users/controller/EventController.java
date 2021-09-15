package yte.intern.project.application.users.controller;

import org.springframework.web.bind.annotation.*;
import yte.intern.project.application.common.infomessage.MessageResponse;
import yte.intern.project.application.users.controller.request.AddEventRequest;
import yte.intern.project.application.users.controller.request.AddUsersRequest;
import yte.intern.project.application.users.controller.request.UpdateEventRequest;
import yte.intern.project.application.users.controller.request.UpdateUsersRequest;
import yte.intern.project.application.users.controller.response.EventQueryResponse;
import yte.intern.project.application.users.entity.Event;
import yte.intern.project.application.users.entity.Users;
import yte.intern.project.application.users.service.EventService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<EventQueryResponse> getAllEvents() {
        return eventService.getAllEvents()
                .stream()
                .map(event -> new EventQueryResponse(event))
                .toList();
    }

    @PostMapping("/events")
    public MessageResponse addEvent(@Valid @RequestBody AddEventRequest addEventRequest) {
        Event event = addEventRequest.toEntity();
        return eventService.addEvent(event);
    }

    @PutMapping("/events/{id}")
    public MessageResponse updateEvent(@PathVariable Long id, @Valid @RequestBody UpdateEventRequest updateEventRequest) {
        return eventService.updateEvent(id, updateEventRequest.toEntity());
    }

    @DeleteMapping("/events/{id}")
    public MessageResponse deleteEvent(@PathVariable Long id) {
        return eventService.deleteEvent(id);
    }
}
