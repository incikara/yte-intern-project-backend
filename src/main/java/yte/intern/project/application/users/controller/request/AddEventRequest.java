package yte.intern.project.application.users.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import yte.intern.project.application.users.entity.Event;

import java.time.LocalDate;


@RequiredArgsConstructor
@Getter
@ToString
public class AddEventRequest {

    private final String eventName;
    private final LocalDate startDate;
    private final LocalDate finishDate;
    private final String eventLocation;
    private final String number;
    private final String imageURL;

    public Event toEntity() {
        return new Event(eventName, startDate, finishDate, eventLocation, number, imageURL);
    }
}
