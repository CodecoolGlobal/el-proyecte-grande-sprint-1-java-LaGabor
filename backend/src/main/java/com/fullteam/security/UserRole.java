package com.fullteam.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public enum UserRole {
    USER(new HashSet<>(Arrays.asList(UserPermission.USER_READ, UserPermission.USER_WRITE))),
    ADMIN(new HashSet<>(Arrays.asList(UserPermission.ADMIN_READ, UserPermission.ADMIN_WRITE, UserPermission.USER_READ, UserPermission.USER_WRITE)));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities =
        permissions.stream()
                .map(permissions -> new SimpleGrantedAuthority(permissions.getPermission()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }
}
