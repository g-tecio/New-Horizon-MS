package com.cwgx.newhorizon.repositories;

import com.cwgx.newhorizon.model.EventImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface EventImageRepository extends CrudRepository<EventImage, Integer> {
    @Query(value = "SELECT * FROM event_image WHERE id_event_image = ?1", nativeQuery = true)
    EventImage imageFindById(Integer id);
}
