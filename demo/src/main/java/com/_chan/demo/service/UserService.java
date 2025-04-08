package com._chan.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com._chan.demo.model.User;
import com._chan.demo.repository.UserRepository;


@Service
public class UserService {
    private final UserRepository userRepo;
    
    @Autowired
    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public User registerUser(User user){
        return userRepo.save(user);
    }

    public User loginUser(User user){
        User foundUser = null;

        if (user.getUsername() != null && !user.getUsername().isEmpty()) {
            foundUser = userRepo.findByUsername(user.getUsername());
        } else if (user.getEmail() != null && !user.getEmail().isEmpty()) {
            foundUser = userRepo.findByEmail(user.getEmail());
        }
    
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return foundUser;
        }
    
        return null;
    }
}
