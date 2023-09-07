package com.msdev.order_controller_api.service;

import com.msdev.order_controller_api.DTO.DTOLogin;
import com.msdev.order_controller_api.DTO.DTONewManager;
import com.msdev.order_controller_api.DTO.DTOToken;
import com.msdev.order_controller_api.customException.DontAccessTheRoleException;
import com.msdev.order_controller_api.customException.RoleEmptyException;
import com.msdev.order_controller_api.entity.Users;
import com.msdev.order_controller_api.enums.RolesEnum;
import com.msdev.order_controller_api.repository.DefaultUserRepository;
import com.msdev.order_controller_api.security.TokenService;
import com.msdev.order_controller_api.utils.ValidateValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    DefaultUserRepository  defaultUserRepository;

    @Autowired
    ValidateValues validateValues;

    public ResponseEntity createSuperUSer(Users users){

        DTONewManager newManager = new DTONewManager(users.getEmail(), users.getRoles());

//        String getRole = users.getRoles();

//        if(getRole.isEmpty()) {
//            throw new RoleEmptyException(newManager);
//        }
//
//        if(RolesEnum.ROLE_USER.equals(RolesEnum.valueOf(getRole))){
//            throw new DontAccessTheRoleException();
//        }

        validateValues.validateEmail(newManager.email());
        validateValues.validPassword(users.getPassword());
//      Encode password
        users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));

        Users newUserSaved = defaultUserRepository.save(users);
        return ResponseEntity.ok().body(new DTONewManager(newUserSaved.getEmail(),newUserSaved.getRoles()));
    }

    public ResponseEntity tokenGenerate(DTOLogin login){
        UserDetails userFromDB = defaultUserRepository.findByEmail(login.email());
        if(new BCryptPasswordEncoder().matches(login.password(),userFromDB.getPassword())){
            String token = new TokenService().generateToken(userFromDB);
            return ResponseEntity.ok().body(new DTOToken(token));
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
}
