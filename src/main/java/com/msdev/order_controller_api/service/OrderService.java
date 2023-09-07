package com.msdev.order_controller_api.service;

import com.msdev.order_controller_api.entity.OrderEntity;
import com.msdev.order_controller_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public ResponseEntity newOrder(OrderEntity orderEntity){
        orderRepository.save(orderEntity);
        return ResponseEntity.ok().body("order Savade");
    }
}
