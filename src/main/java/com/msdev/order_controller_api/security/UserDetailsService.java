package com.msdev.order_controller_api.security;


import com.msdev.order_controller_api.repository.DefaultUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    DefaultUserRepository defaultUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails getUser = defaultUserRepository.findByEmail(username);
        UserDetails authUser = User.withUsername(getUser.getUsername()).password(getUser.getPassword()).authorities(getUser.getAuthorities()).build();
        return authUser;
    }
}
