package com.oddify.capstone.userserviceapr24.services;

import com.oddify.capstone.userserviceapr24.models.Token;
import com.oddify.capstone.userserviceapr24.models.User;
import com.oddify.capstone.userserviceapr24.repos.TokenRepo;
import com.oddify.capstone.userserviceapr24.repos.UserRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    BCryptPasswordEncoder bCryptPasswordEncoder;
    UserRepo userRepo;

    TokenRepo tokenRepo ;

    public UserServiceImpl(  BCryptPasswordEncoder bCryptPasswordEncoder,UserRepo userRepo,TokenRepo tokenRepo){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
    }

    @Override
    public User signUP(String name, String email, String password) {
        User user = new User();

        user.setEmail(email);
        user.setName(name);
        user.setHashedPassword(bCryptPasswordEncoder.encode(password));

        user =  userRepo.save(user);

        return  user;

    }

    @Override
    public Token login(String email, String password) {
        // Check if user exists
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        // Verify password
        if (!bCryptPasswordEncoder.matches(password, user.get().getHashedPassword())) {
            throw new UsernameNotFoundException("User or password is incorrect");
        }

        Token token = generateToken(user.get());

        tokenRepo.save(token);

        // Generate token
        return token;

    }

    @Override
    public User validateToken(String tokenValue) {
        // get token from db
        Optional<Token> token = tokenRepo.findByValueAndExpiryAtGreaterThan(tokenValue, new Date());

        // check if token is valid
        if(token.isEmpty()){
            throw new RuntimeException("Invalid Token");
        }
        // return user
        return  token.get().getUser();
    }

    private Token generateToken(User user){
        Token token = new Token();
        token.setCreatedDate(new Date());
        token.setUser(user);
        token.setValue(RandomStringUtils.randomAlphanumeric(16));
        LocalDate currentDate = LocalDate.now();
        LocalDate thirtyDaysLater = currentDate.plusDays(30);

        Date expiryDate = Date.from(thirtyDaysLater.atStartOfDay(ZoneId.systemDefault()).toInstant());
        token.setExpiryAt(expiryDate);
        return  token;
    }

}
