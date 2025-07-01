package com.reminder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reminder.model.User;
import com.reminder.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

}
