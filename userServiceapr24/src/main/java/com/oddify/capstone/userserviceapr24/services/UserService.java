package com.oddify.capstone.userserviceapr24.services;

import com.oddify.capstone.userserviceapr24.models.Token;
import com.oddify.capstone.userserviceapr24.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User signUP(String name, String email, String password);

    public Token login(String email, String password);

    public User validateToken(String token);
}
