package com.cwgx.newhorizon.rest;

import com.cwgx.newhorizon.model.User;
import com.cwgx.newhorizon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(path = "/users/{userName}", method = RequestMethod.GET)
    public @ResponseBody User userFindByName(@PathVariable String userName) {
        // This returns a JSON or XML with the users
        return userRepository.userFindByName(userName);
    }

    @PostMapping("/users/post")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }
}