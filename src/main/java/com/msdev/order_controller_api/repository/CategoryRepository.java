package com.msdev.order_controller_api.repository;

import com.msdev.order_controller_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findByName(String name);
}
