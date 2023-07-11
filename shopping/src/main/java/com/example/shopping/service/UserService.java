package com.example.shopping.service;

import com.example.shopping.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUser();

    User createUser(User user);

    UserDetails loadUserById(String id);

    User getUserById(String id);
}
