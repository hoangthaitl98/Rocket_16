package com.example.shopping.service;

import com.example.shopping.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User createUser (User user);
}
