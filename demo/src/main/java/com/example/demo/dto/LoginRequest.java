package com.example.demo.dto;

import lombok.*;

@Getter @Setter
public class LoginRequest {
    private String email;
    private String password;
}
