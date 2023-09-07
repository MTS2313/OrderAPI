package com.msdev.order_controller_api.controller;


import com.msdev.order_controller_api.entity.OrderEntity;
import com.msdev.order_controller_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("new")
    private ResponseEntity newOrder(@RequestBody OrderEntity orderEntity){
        Timestamp timestamp = Timestamp.valueOf(String.valueOf(orderEntity.getOrderTime()));
        orderEntity.setOrderTime(timestamp);
        return orderService.newOrder(orderEntity);
    }
}
