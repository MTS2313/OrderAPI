package com.msdev.order_controller_api.repository;

import com.msdev.order_controller_api.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity,String> {
}
