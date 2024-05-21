package com.example.demo.dto;

import com.example.demo.enums.Role;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegisterUserDto {

    private String username;
    private String password;
    private Role role;
}
