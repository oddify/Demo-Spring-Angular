package com.oddify.capstone.userserviceapr24.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {

    String email;
    String password;
}
