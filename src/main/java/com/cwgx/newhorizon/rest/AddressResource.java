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

    @RequestMapping(method=RequestMethod.PUT, value="address/update/{id_address}")
    public Address updateAddress(@PathVariable Integer id_address, @RequestBody Address address) {
        Address updateAddress = addressRepository.findOne(id_address);
        updateAddress.setEvent_id(address.getEvent_id());
        updateAddress.setLine_address1(address.getLine_address1());
        updateAddress.setLine_address2(address.getLine_address2());
        updateAddress.setCity(address.getCity());
        updateAddress.setState(address.getState());
        updateAddress.setZip_code(address.getZip_code());
        return addressRepository.save(updateAddress);
    }
}
