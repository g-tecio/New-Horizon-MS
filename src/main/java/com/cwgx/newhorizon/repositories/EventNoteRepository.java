package com.cwgx.newhorizon.repositories;
import com.cwgx.newhorizon.model.EventNote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface EventNoteRepository extends CrudRepository<EventNote, Integer> {
@Query(value = "SELECT * FROM event_note WHERE id_event_note = ?1", nativeQuery = true)
    EventNote noteFindById(Integer id);
}
