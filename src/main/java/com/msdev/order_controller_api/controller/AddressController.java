package com.msdev.order_controller_api.controller;


import com.msdev.order_controller_api.entity.Address;
import com.msdev.order_controller_api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("new")
    private ResponseEntity newAddress(@RequestBody Address address){
        return addressService.insertAddress(address);
    }
}
