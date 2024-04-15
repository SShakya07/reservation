package com.airbnb.service;

import com.airbnb.dto.LoginDto;
import com.airbnb.dto.PropertyUserDto;
import com.airbnb.entity.PropertyUser;
import com.airbnb.repository.PropertyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private PropertyUserRepository  propertyUserRepository;
    @Autowired
    private JWTService jwtService;

    public PropertyUser addUser(PropertyUserDto propertyUserDto){
         PropertyUser user = new PropertyUser();
         user.setFirstName(propertyUserDto.getFirstName());
         user.setLastName(propertyUserDto.getLastName());
         user.setUsername(propertyUserDto.getUsername());
         user.setEmail(propertyUserDto.getEmail());
         user.setUserRole(propertyUserDto.getUserRole());
         user.setPassword(BCrypt.hashpw(propertyUserDto.getPassword(),BCrypt.gensalt(10)));

         propertyUserRepository.save(user);
         return user;
    }

    public String  verifyLogin(LoginDto loginDto) {

        Optional<PropertyUser> opUser = propertyUserRepository.findByUsername(loginDto.getUsername());
        if(opUser.isPresent()){
            PropertyUser user = opUser.get();
             if (BCrypt.checkpw(loginDto.getPassword(),user.getPassword())){
                 return  jwtService.generateToken(user);
             }
        }
        return null;
    }
}
