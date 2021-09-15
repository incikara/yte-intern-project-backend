package yte.intern.project.application.users.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.project.application.common.entity.BaseEntity;

import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor
public class Event extends BaseEntity {

    private String eventName;
    private LocalDate  startDate;
    private LocalDate finishDate;
    private String eventLocation;
    private String number;
    private String imageURL;

    public Event(String eventName, LocalDate startDate, LocalDate finishDate, String eventLocation, String number, String imageURL) {
        this.eventName = eventName;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.eventLocation = eventLocation;
        this.number = number;
        this.imageURL = imageURL;
    }

    public void updateEvent(Event newEvent) {

        this.eventName = newEvent.getEventName();
        this.startDate = newEvent.getStartDate();
        this.finishDate = newEvent.getFinishDate();
        this.eventLocation = newEvent.getEventLocation();
        this.number = newEvent.getNumber();
        this.imageURL = newEvent.getImageURL();

    }

}
