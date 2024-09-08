package com.oddify.capstone.userserviceapr24.controllers;

import com.oddify.capstone.userserviceapr24.dtos.LoginRequestDto;
import com.oddify.capstone.userserviceapr24.dtos.SignUpRequestDto;
import com.oddify.capstone.userserviceapr24.dtos.UserDto;
import com.oddify.capstone.userserviceapr24.dtos.ValidateRequestDto;
import com.oddify.capstone.userserviceapr24.models.Token;
import com.oddify.capstone.userserviceapr24.models.User;
import com.oddify.capstone.userserviceapr24.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignUpRequestDto requestDTO){
        User user = userService.signUP(requestDTO.getName(), requestDTO.getEmail(), requestDTO.getPassword());
        return UserDto.from(user);
    }

    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto requestDto){
        Token token =  userService.login(requestDto.getEmail(), requestDto.getPassword());

        return token;
    }


    @PostMapping("/validate")
    public UserDto validate(@RequestBody ValidateRequestDto requestDto){
        User user =  userService.validateToken(requestDto.getValue());

        return UserDto.from(user);
    }

    @PostMapping("/validate/{token}")
    public UserDto validatePathToken(@PathVariable String token){
        try {
            User user =  userService.validateToken(token);
            return UserDto.from(user);
        } catch (Exception e) {
            return null;
        }
    }
}
