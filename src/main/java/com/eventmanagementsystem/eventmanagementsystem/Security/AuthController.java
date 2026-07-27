package com.eventmanagementsystem.eventmanagementsystem.Security;

import com.eventmanagementsystem.eventmanagementsystem.entity.User;
import com.eventmanagementsystem.eventmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User register(
            @RequestBody User user) {

        user.setPassword(
                passwordEncoder.encode(
                        user.getPassword()));

        return repository.save(user);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody AuthRequest request) {

        User user = repository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Invalid Email"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException(
                    "Invalid Password");
        }

        return jwtUtil.generateToken(
                user.getEmail());
    }
}