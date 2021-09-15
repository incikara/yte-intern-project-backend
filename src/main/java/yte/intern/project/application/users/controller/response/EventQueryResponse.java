package yte.intern.project.application.users.controller.response;

import lombok.Getter;
import yte.intern.project.application.users.entity.Event;

import java.time.LocalDate;


@Getter
public class EventQueryResponse {

    private final Long id;
    private final String eventName;
    private final LocalDate startDate;
    private final LocalDate finishDate;
    private final String eventLocation;
    private final String number;
    private final String imageURL;


    public EventQueryResponse(Event event) {
        this.id = event.getId();
        this.eventName = event.getEventName();
        this.startDate = event.getStartDate();
        this.finishDate = event.getFinishDate();
        this.eventLocation = event.getEventLocation();
        this.number = event.getNumber();
        this.imageURL = event.getImageURL();
    }
}
