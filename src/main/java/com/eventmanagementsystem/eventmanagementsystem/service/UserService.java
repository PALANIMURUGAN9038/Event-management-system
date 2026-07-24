package com.eventmanagementsystem.eventmanagementsystem.service;

import com.eventmanagementsystem.eventmanagementsystem.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

    User updateUser(Integer id, User user);

    void deleteUser(Integer id);

    User login(String email, String password);
}