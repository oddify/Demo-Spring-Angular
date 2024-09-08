package com.oddify.capstone.userserviceapr24.security.services;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.oddify.capstone.userserviceapr24.models.User;
import com.oddify.capstone.userserviceapr24.repos.UserRepo;
import com.oddify.capstone.userserviceapr24.security.models.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@JsonDeserialize
public class CustomUserDetailService implements UserDetailsService {

    UserRepo userRepo;

     public CustomUserDetailService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new CustomUserDetails(user.get());

    }
}
