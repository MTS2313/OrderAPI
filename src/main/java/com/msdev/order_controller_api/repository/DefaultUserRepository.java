package com.msdev.order_controller_api.repository;

import com.msdev.order_controller_api.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface DefaultUserRepository extends MongoRepository<Users, UUID> {
    UserDetails findByEmail(String email);
}
