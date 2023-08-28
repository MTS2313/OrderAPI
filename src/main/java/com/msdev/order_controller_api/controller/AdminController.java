package com.msdev.order_controller_api.controller;


import com.msdev.order_controller_api.DTO.DTOLogin;
import com.msdev.order_controller_api.entity.Users;
import com.msdev.order_controller_api.service.ControlManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/control")
public class AdminController {
    @Autowired
    ControlManagerService controlManagerService;
    @PostMapping("/register")
    private ResponseEntity saveManager(@RequestBody Users users){
        return controlManagerService.createSuperUSer(users);
    }
    @PostMapping("/login")
    private ResponseEntity loginTokenProvider(@RequestBody DTOLogin login){
            return  controlManagerService.tokenGenerate(login);
    }
}
