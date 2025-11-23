package com.example.demo.dto;

import lombok.*;

@Getter @Setter
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
}
