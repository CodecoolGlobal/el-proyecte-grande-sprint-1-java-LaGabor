package com.fullteam.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JwtUsernameAndPasswordAuthenticationRequest {
    private String username;
    private String password;

    public JwtUsernameAndPasswordAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
