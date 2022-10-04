package com.fullteam.controller.dto;

import com.fullteam.security.PasswordConfig;
import com.fullteam.security.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;


@Getter
@Setter
public class RegistrationProfileDto {
    private String password;
    private String email;
    private  String username;
    private LocalDate birthDate;

}
