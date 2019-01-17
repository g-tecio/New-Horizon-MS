package com.cwgx.newhorizon.rest;
import com.cwgx.newhorizon.repositories.EventImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.cwgx.newhorizon.model.EventImage;

@Controller
@RestController
public class EventImageResource {
    @Autowired
    private EventImageRepository event_imageRepository;
    @RequestMapping(path = "/image", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<EventImage> getAllUsers() {
        // This returns a JSON or XML with the users
        return event_imageRepository.findAll();
    }
    /*
    @RequestMapping(path = "/eve/{Id}", method = RequestMethod.GET)
    public @ResponseBody
    Event_image userFindById(@PathVariable Integer userId) {
        // This returns a JSON or XML with the users
        return event_imageRepository.imageFindById(userId);
    }*/
    @PostMapping("/image/post")
    EventImage newImage(@RequestBody EventImage newImage){
        return event_imageRepository.save(newImage);
    }

    @RequestMapping(method=RequestMethod.PUT, value="image/update/{id_event_image}")
    public EventImage updateImage(@PathVariable Integer id_event_image, @RequestBody EventImage eventImage) {
        EventImage updateImage = event_imageRepository.findOne(id_event_image);
        updateImage.setEvent_id(eventImage.getEvent_id());
        updateImage.setSource(eventImage.getSource());
        updateImage.setCreated_at(eventImage.getCreated_at());
        updateImage.setStatus(eventImage.getStatus());
        return event_imageRepository.save(updateImage);
    }
}
