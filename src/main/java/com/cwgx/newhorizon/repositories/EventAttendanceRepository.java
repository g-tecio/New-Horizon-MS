package com.cwgx.newhorizon.repositories;

import com.cwgx.newhorizon.model.EventAttendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EventAttendanceRepository extends CrudRepository<EventAttendance, Integer> {
    @Query(value = "SELECT * FROM event_attendance WHERE id_event_attendance = ?1", nativeQuery = true)
    EventAttendance findAttendanceById(Integer id_event_attendance);
}
