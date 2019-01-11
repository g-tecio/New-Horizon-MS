package com.cwgx.newhorizon.rest;
import com.cwgx.newhorizon.model.Event;
import com.cwgx.newhorizon.model.EventNote;
import com.cwgx.newhorizon.model.SocialLink;
import com.cwgx.newhorizon.repositories.EventNoteRepository;
import com.cwgx.newhorizon.repositories.SocialLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RestController
public class EventNoteResource {
    @Autowired
    private EventNoteRepository evenoteRepository;
    @RequestMapping(path = "/note", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<EventNote> getAllUsers() {
        // This returns a JSON or XML with the users
        return evenoteRepository.findAll();
    }
    @RequestMapping(path = "/note/{id_note}", method = RequestMethod.GET)
    public @ResponseBody
    EventNote findEventById(@PathVariable Integer id_note) {
        return evenoteRepository.noteFindById(id_note);
    }

    @PostMapping("/note/post")
    EventNote newNote(@RequestBody EventNote newNote){
        return evenoteRepository.save(newNote);
    }
}
