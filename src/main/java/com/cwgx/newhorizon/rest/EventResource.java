package com.cwgx.newhorizon.rest;


import com.cwgx.newhorizon.model.Event;
import com.cwgx.newhorizon.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class EventResource {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(path = "/events", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Event> getAllEvents() {
        // This returns a JSON or XML with the users
        return eventRepository.findAll();
    }

    @PostMapping("/events/post")
    Event newEvent(@RequestBody Event newEvent){
        return eventRepository.save(newEvent);
    }

}
