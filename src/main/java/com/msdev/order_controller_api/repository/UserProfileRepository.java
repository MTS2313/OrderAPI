package com.msdev.order_controller_api.repository;

import com.msdev.order_controller_api.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile,String> {
}
