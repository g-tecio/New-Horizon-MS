package com.cwgx.newhorizon.rest;

import com.cwgx.newhorizon.model.Address;
import com.cwgx.newhorizon.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class AddressResource {

    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping(path = "/address", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Address> getAllAddress() {
        // This returns a JSON or XML with the users
        return addressRepository.findAll();
    }
    @PostMapping("/address/post")
    Address newAddress(@RequestBody Address newAddress){
        return addressRepository.save(newAddress);
    }

}
