package com.cwgx.newhorizon.rest;
import com.cwgx.newhorizon.repositories.EventImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.cwgx.newhorizon.model.EventImage;

@Controller
@RestController
public class EventImageResouce {
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
}
