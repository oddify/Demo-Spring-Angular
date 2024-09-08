package com.oddify.capstone.userserviceapr24.security.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.oddify.capstone.userserviceapr24.models.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


@Getter
@Setter
@JsonDeserialize
@NoArgsConstructor
public class CustomGrantedAuthorities implements GrantedAuthority {

    private String authority;

    public CustomGrantedAuthorities(Role role){
        this.authority = role.getValue();
    }


    @Override
    public String getAuthority() {
       return this.authority;
    }
}
