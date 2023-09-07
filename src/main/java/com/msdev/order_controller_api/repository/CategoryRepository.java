package com.msdev.order_controller_api.repository;

import com.msdev.order_controller_api.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Category findByName(String name);
}
