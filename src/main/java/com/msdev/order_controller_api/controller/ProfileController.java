package com.msdev.order_controller_api.controller;


import com.msdev.order_controller_api.DTO.DTOProfileBody;
import com.msdev.order_controller_api.DTO.DTOUser;
import com.msdev.order_controller_api.entity.UserProfile;
import com.msdev.order_controller_api.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profile")
public class ProfileController {
    @Autowired
    UserProfileService userProfileService;


    @GetMapping(params = {"type","find"})
    private ResponseEntity findProfile(@RequestParam String type, @RequestParam String find){
        return  ResponseEntity.ok().body(String.format("find is: %s, and type is %s",type,find));
    }

    @PostMapping(value = "new")
    private ResponseEntity saveProfile(@RequestBody DTOProfileBody dtoProfileBody, @AuthenticationPrincipal UserDetails userDetails){
        DTOUser userInfo = new DTOUser(userDetails.getUsername(),userDetails.getAuthorities().toString());
        return userProfileService.userProfileSave(dtoProfileBody, userInfo);
    }
}
