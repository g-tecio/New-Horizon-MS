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

    /*@RequestMapping(value = "events/update/{id_event}", method = RequestMethod.PUT)
    public void updateById(@PathVariable("id_event") Integer id_event, @RequestBody Event event) {

    }*/

    @RequestMapping(method=RequestMethod.PUT, value="events/update/{id_event}")
    public Event updateEvent(@PathVariable Integer id_event, @RequestBody Event event) {
        Event updateEvent = eventRepository.findOne(id_event);
        updateEvent.setEvent_name(event.getEvent_name());
        updateEvent.setDescription(event.getDescription());
        updateEvent.setVenue_name(event.getVenue_name());
        updateEvent.setAttire(event.getAttire());
        updateEvent.setEvent_image(event.getEvent_image());
        updateEvent.setCapacity(event.getCapacity());
        updateEvent.setRevenue_generation(event.getRevenue_generation());
        updateEvent.setStart_date(event.getStart_date());
        updateEvent.setEnd_date(event.getEnd_date());
        updateEvent.setLatitude(event.getLatitude());
        updateEvent.setLongitude(event.getLongitude());
        updateEvent.setEvent_type(event.getEvent_type());
        updateEvent.setStatus(event.getStatus());
        updateEvent.setPublished(event.isPublished());
        updateEvent.setEvent_price(event.getEvent_price());
        return eventRepository.save(updateEvent);
    }
}
