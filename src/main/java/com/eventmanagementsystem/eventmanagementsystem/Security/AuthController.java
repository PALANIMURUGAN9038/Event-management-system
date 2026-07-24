package com.eventmanagementsystem.eventmanagementsystem.Security;

import com.eventmanagementsystem.eventmanagementsystem.entity.User;
import com.eventmanagementsystem.eventmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(
            @RequestBody AuthRequest request) {

        User user = repository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Invalid Email"));

        if (!user.getPassword()
                .equals(request.getPassword())) {

            throw new RuntimeException(
                    "Invalid Password");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}