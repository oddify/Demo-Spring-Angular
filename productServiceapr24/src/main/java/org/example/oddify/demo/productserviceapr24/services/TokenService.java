package org.example.oddify.demo.productserviceapr24.services;

import org.example.oddify.demo.productserviceapr24.dtos.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TokenService {

    RestTemplate restTemplate;

    public TokenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Boolean validateToken(String token) {
        UserDto userDto =  restTemplate.postForObject("http://localhost:9000/users/validate/" + token,null, UserDto.class);

        return userDto != null;
    }

}
