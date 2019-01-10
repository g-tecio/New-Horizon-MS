package com.cwgx.newhorizon.repositories;

import com.cwgx.newhorizon.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
    @Query(value = "SELECT * FROM event WHERE id_event = ?1", nativeQuery = true)
    Event findEventById(Integer id_event);
}
