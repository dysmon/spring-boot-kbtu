package com.example.casbinexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class User {
    private final String username;
    private final String password;

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }
}
