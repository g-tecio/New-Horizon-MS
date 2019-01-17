package com.cwgx.newhorizon.rest;

import com.cwgx.newhorizon.model.EventAttendance;
import com.cwgx.newhorizon.repositories.EventAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class EventAttendanceResource {
    @Autowired
    private EventAttendanceRepository eventAttendanceRepository;

    @RequestMapping(path = "/eventsAttendance", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<EventAttendance> getAllEvents() {
        // This returns a JSON or XML with the users
        return eventAttendanceRepository.findAll();
    }

    @PostMapping("/eventsAttendance/post")
    EventAttendance newEventAttendance(@RequestBody EventAttendance newEventAttendance){
        return eventAttendanceRepository.save(newEventAttendance);
    }

    @RequestMapping(path = "/eventsAttendance/{id_event_attendance}", method = RequestMethod.GET)
    public @ResponseBody EventAttendance findAttendanceById(@PathVariable Integer id_event_attendance) {
        return eventAttendanceRepository.findAttendanceById(id_event_attendance);
    }

    @RequestMapping(method=RequestMethod.PUT, value="eventsAttendance/update/{id_event_attendance}")
    public EventAttendance updateEventAttendance(@PathVariable Integer id_event_attendance, @RequestBody EventAttendance eventAttendance) {
        EventAttendance updateEventAttendance = eventAttendanceRepository.findOne(id_event_attendance);
        updateEventAttendance.setEvent_id(eventAttendance.getEvent_id());
        updateEventAttendance.setCustomer_id(eventAttendance.getCustomer_id());
        updateEventAttendance.setCustomer_name(eventAttendance.getCustomer_name());
        updateEventAttendance.setLast_modified(eventAttendance.getLast_modified());
        updateEventAttendance.setCreated_at(eventAttendance.getCreated_at());
        updateEventAttendance.setStatus(eventAttendance.getStatus());
        return eventAttendanceRepository.save(updateEventAttendance);
    }
}
