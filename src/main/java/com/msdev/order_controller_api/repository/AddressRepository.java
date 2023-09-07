package com.msdev.order_controller_api.repository;

import com.msdev.order_controller_api.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address,String> {
}
