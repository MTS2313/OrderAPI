package com.msdev.order_controller_api.repository;

import com.msdev.order_controller_api.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, UUID> {
}
