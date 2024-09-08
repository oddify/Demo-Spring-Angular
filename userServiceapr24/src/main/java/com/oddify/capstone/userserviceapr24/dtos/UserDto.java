package com.oddify.capstone.userserviceapr24.dtos;

import com.oddify.capstone.userserviceapr24.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserDto {

    private String email;
    private String name;
    private List<RoleDto> roles;

    public static UserDto from (User user){
        UserDto userDto = new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        if(user.getRoles() != null) {
            userDto.setRoles(user.getRoles().stream().map(RoleDto::from).collect(Collectors.toList()));
        }

        return  userDto;
    }

}
