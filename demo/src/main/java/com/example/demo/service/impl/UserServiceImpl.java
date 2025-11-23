package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    @org.springframework.beans.factory.annotation.Autowired
    @Lazy
    private AuthenticationManager authManager;
    private final JwtUtil jwt;

    public AuthResponse register(RegisterRequest req) {

        if (repo.existsByEmail(req.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .email(req.getEmail())
                .username(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .name(req.getName())
                .build();

        repo.save(user);

        String token = jwt.generateToken(req.getEmail());
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(LoginRequest req) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));

        String token = jwt.generateToken(req.getEmail());
        return new AuthResponse(token);
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
