package com.oddify.capstone.userserviceapr24.dtos;

import com.oddify.capstone.userserviceapr24.models.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
    private String value;

    public static RoleDto from(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setValue(role.getValue());
        return roleDto;
    }
}
