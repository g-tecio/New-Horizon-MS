package com.cwgx.newhorizon.rest;
import com.cwgx.newhorizon.model.EventImage;
import com.cwgx.newhorizon.model.EventNote;
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
    @RequestMapping(path = "/socialnet/{id_social}", method = RequestMethod.GET)
    public @ResponseBody
    SocialLink findEventById(@PathVariable Integer id_social) {
        return social_linkRepository.socialFindById(id_social);
    }
    @PostMapping("/socialnet/post")
    SocialLink newSocial(@RequestBody SocialLink newSocial){
        return social_linkRepository.save(newSocial);
    }

    @RequestMapping(method=RequestMethod.PUT, value="socialnet/update/{id_social_link}")
    public SocialLink updateSocialLink(@PathVariable Integer id_social_link, @RequestBody SocialLink socialLink) {
        SocialLink updateSocialLink = social_linkRepository.findOne(id_social_link);
        updateSocialLink.setEvent_id(socialLink.getEvent_id());
        updateSocialLink.setSocial_network(socialLink.getSocial_network());
        updateSocialLink.setSource(socialLink.getSource());
        updateSocialLink.setStatus(socialLink.getStatus());
        return social_linkRepository.save(updateSocialLink);
    }
}
