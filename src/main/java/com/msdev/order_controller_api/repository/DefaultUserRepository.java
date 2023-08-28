package com.msdev.order_controller_api.repository;

import com.msdev.order_controller_api.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface DefaultUserRepository extends JpaRepository<Users, UUID> {
    UserDetails findByEmail(String email);
}
