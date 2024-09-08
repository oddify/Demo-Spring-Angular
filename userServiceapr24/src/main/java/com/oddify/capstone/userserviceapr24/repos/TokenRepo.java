package com.oddify.capstone.userserviceapr24.repos;

import com.oddify.capstone.userserviceapr24.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRepo extends JpaRepository<Token,Long> {
    Optional<Token> findByValueAndExpiryAtGreaterThan(String value, Date expiryAt);
}
