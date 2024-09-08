package com.oddify.capstone.userserviceapr24.security.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.oddify.capstone.userserviceapr24.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@JsonDeserialize
@Getter
@Setter
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {

    private String password;
    private String username;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;

    private List<CustomGrantedAuthorities> authorities;

    private Long userId;

    public CustomUserDetails(User user){
        this.username = user.getEmail();
        this.password = user.getHashedPassword();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.userId = user.getId();


        // TODO: set authorities
        this.authorities = new ArrayList<>();
        for(int i = 0; i < user.getRoles().size(); i++){
            this.authorities.add(new CustomGrantedAuthorities(user.getRoles().get(i)));
        }


    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
