package com.airbnb.controller;

import com.airbnb.dto.JWTResponse;
import com.airbnb.dto.LoginDto;
import com.airbnb.dto.PropertyUserDto;
import com.airbnb.entity.PropertyUser;
import com.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    //http://localhost:8080/api/v1/users/addUser
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody PropertyUserDto dto){
        PropertyUser user = userService.addUser(dto);
        if(user!= null) {
            return new ResponseEntity<>("Sign Up Successful", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody LoginDto loginDto){
        String jwtToken = userService.verifyLogin(loginDto);

        if(jwtToken != null) {
            JWTResponse jwtResponse = new JWTResponse();
            jwtResponse.setToken(jwtToken);
             return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
         }
        return new ResponseEntity<>("Invalid Credential", HttpStatus.UNAUTHORIZED);

    }
    @GetMapping("/profile")
    public PropertyUser getCurrentProfile(@AuthenticationPrincipal PropertyUser propertyUser){
        return propertyUser;
    }



}
