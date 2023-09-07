package com.msdev.order_controller_api.service;

import com.msdev.order_controller_api.entity.Address;
import com.msdev.order_controller_api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public ResponseEntity insertAddress(Address address){
        return ResponseEntity.ok().body(addressRepository.save(address));
    }
}
