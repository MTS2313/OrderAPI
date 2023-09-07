package com.msdev.order_controller_api.service;

import com.msdev.order_controller_api.DTO.DTOProfileBody;
import com.msdev.order_controller_api.DTO.DTOUser;
import com.msdev.order_controller_api.entity.UserProfile;
import com.msdev.order_controller_api.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    @Autowired
    UserProfileRepository userProfileRepository;
    public ResponseEntity userProfileSave(DTOProfileBody dtoProfileBody, DTOUser dtoUser){
        UserProfile profile = new UserProfile(dtoUser,dtoProfileBody);
        return ResponseEntity.ok().body(userProfileRepository.save(profile));
    }
}
