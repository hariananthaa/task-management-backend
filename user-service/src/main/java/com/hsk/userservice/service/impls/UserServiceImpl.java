package com.hsk.userservice.service.impls;

import com.hsk.userservice.exception.AlreadyExistingException;
import com.hsk.userservice.exception.NotFoundException;
import com.hsk.userservice.persistent.entity.User;
import com.hsk.userservice.persistent.repository.UserRepository;
import com.hsk.userservice.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User registerUser(User user) {
        User existingUser = getUserByEmail(user.getEmail());
        if(existingUser != null){
            throw new AlreadyExistingException("User already exist with this email.");
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new NotFoundException("User not found."));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

    @Override
    @Transactional
    public User updateUserById(Long userId,User user) {
        User existingUser = getUserById(userId);

        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public User deleteUserById(Long userId) {
        User user = getUserById(userId);
        userRepository.deleteById(userId);
        return user;
    }
}
