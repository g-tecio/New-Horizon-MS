package com.cwgx.newhorizon.rest;
import com.cwgx.newhorizon.model.EventImage;
import com.cwgx.newhorizon.model.SocialLink;
import com.cwgx.newhorizon.repositories.EventImageRepository;
import com.cwgx.newhorizon.repositories.SocialLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RestController
public class SocialLinkResource {
    @Autowired
    private SocialLinkRepository social_linkRepository;
    @RequestMapping(path = "/socialnet", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<SocialLink> getAllUsers() {
        // This returns a JSON or XML with the users
        return social_linkRepository.findAll();
    }
    @PostMapping("/socialnet/post")
    SocialLink newSocial(@RequestBody SocialLink newSocial){
        return social_linkRepository.save(newSocial);
    }
}
