package com.example.casbinexample.config;

import org.springframework.security.core.GrantedAuthority;


public record GrantedAuthorityImpl(String authority) implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return authority;
    }
}
