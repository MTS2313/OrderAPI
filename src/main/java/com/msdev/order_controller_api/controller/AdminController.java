package com.msdev.order_controller_api.controller;


import com.msdev.order_controller_api.DTO.DTOLogin;
import com.msdev.order_controller_api.entity.Users;
import com.msdev.order_controller_api.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/control")
public class AdminController {
    @Autowired
    UsersService usersService;
    @PostMapping("/register")
    private ResponseEntity saveManager(@RequestBody Users users){
        return usersService.createSuperUSer(users);
    }
    @PostMapping("/login")
    private ResponseEntity loginTokenProvider(@RequestBody DTOLogin login){
            return  usersService.tokenGenerate(login);
    }
}
