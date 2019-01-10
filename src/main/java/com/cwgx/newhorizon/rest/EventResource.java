package com.cwgx.newhorizon.rest;


import com.cwgx.newhorizon.model.Event;
import com.cwgx.newhorizon.repositories.EventRepository;
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

    @RequestMapping(path = "/events/{id_event}", method = RequestMethod.GET)
    public @ResponseBody Event findEventById(@PathVariable Integer id_event) {
        return eventRepository.findEventById(id_event);
    }
}
