package com.airbnb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private JWTRequestFilter jwtRequestFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable().cors().disable();
        httpSecurity.addFilterBefore(jwtRequestFilter, AuthorizationFilter.class);

        httpSecurity.authorizeHttpRequests()
                .requestMatchers("/api/v1/users/addUser","/api/v1/users/login").permitAll()
                .requestMatchers("/api/v1/countries/addCountry").hasRole("ADMIN")
                .requestMatchers("/api/v1/users/profile").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated();
        return httpSecurity.build();

    }
}
