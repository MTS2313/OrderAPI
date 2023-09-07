package com.msdev.order_controller_api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    JWTSecurityFilter JWTSecurityFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      return   http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessio->sessio.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authotize->authotize
                                .requestMatchers(HttpMethod.POST,"/control/login").permitAll()
                                .requestMatchers(HttpMethod.POST,"/control/register").permitAll()
//                                category section
                                .requestMatchers(HttpMethod.POST, "category/*").hasAnyRole("ADMIN","PRODUCT")
                                .requestMatchers(HttpMethod.DELETE, "category/delete").hasAnyRole("ADMIN","PRODUCT")
                                .requestMatchers(HttpMethod.GET, "category/list","product/list").permitAll()
//                                order section
                                .requestMatchers(HttpMethod.POST,"order/new").hasRole("USER")
//                        address end-points
                                .requestMatchers(HttpMethod.POST, "address/*").permitAll()
//                        profile section
                                .requestMatchers(HttpMethod.GET,"profile").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST,"profile/new").hasAnyRole("USER"," ADMIN","PRODUCT","ORDER")
                                .anyRequest()
                                .authenticated()
                        ).addFilterBefore(JWTSecurityFilter, UsernamePasswordAuthenticationFilter.class).build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    }
