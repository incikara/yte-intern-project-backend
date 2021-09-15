package yte.intern.project.application.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.project.application.users.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
