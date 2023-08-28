package com.msdev.order_controller_api.repository;

import com.msdev.order_controller_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
