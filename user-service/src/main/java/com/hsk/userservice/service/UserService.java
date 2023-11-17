package com.hsk.userservice.service;

import com.hsk.userservice.persistent.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    User registerUser(User user);

    User getUserById(Long userId);

    User getUserByEmail(String email);

    User updateUserById(Long userId,User user);

    User deleteUserById(Long userId);

    List<User> getAllUsers();
}
