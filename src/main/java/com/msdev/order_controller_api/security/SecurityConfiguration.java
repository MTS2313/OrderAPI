package com.msdev.order_controller_api.security;

import com.msdev.order_controller_api.service.JWTSecurityFilter;
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
                                .requestMatchers(HttpMethod.POST, "/control/login","/control/register")
                                .hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/product/manager/*")
                                .hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/product/manager/*")
                                .hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET,
                                        "/product/category/list",
                                        "/product/product/list")
                                .permitAll()
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
