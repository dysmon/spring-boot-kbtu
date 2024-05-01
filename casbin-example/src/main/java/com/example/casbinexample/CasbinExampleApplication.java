package com.example.casbinexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class CasbinExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasbinExampleApplication.class, args);
    }

}
