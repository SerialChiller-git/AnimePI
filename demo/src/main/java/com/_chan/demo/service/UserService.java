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
}
