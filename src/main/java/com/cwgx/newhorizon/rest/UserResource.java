package com.cwgx.newhorizon.rest;

import com.cwgx.newhorizon.model.User;
import com.cwgx.newhorizon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RestController
public class UserResource {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    /*@RequestMapping(path = "/users/post", method = RequestMethod.POST)
    public ResponseEntity<User> update(@RequestBody User user){
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }*/

    @PostMapping("/users/post")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }
}