package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF because REST APIs using tokens don't need it
            .csrf(csrf -> csrf.disable())
            
            // Authorize our specific API endpoints to be accessed by anyone
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // Permits all links starting with /api/
                .anyRequest().authenticated()          // Anything else still requires login
            );
            
        return http.build();
    }
}