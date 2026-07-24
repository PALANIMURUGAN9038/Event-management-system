package com.eventmanagementsystem.eventmanagementsystem.service;

import com.eventmanagementsystem.eventmanagementsystem.entity.User;
import com.eventmanagementsystem.eventmanagementsystem.exception.ResourceNotFoundException;
import com.eventmanagementsystem.eventmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User Not Found"));
    }

    @Override
    public User updateUser(Integer id, User user) {

        User existing = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setContactNumber(user.getContactNumber());

        return repository.save(existing);
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public User login(String email, String password) {

        User user = repository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Invalid Email"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid Password");
        }

        return user;
    }
}