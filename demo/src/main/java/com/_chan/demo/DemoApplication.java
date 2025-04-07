package com._chan.demo;

import java.util.HashSet;
import java.util.Set;

import com._chan.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com._chan.demo.repository.UserRepository;
import com._chan.demo.model.User;

@SpringBootApplication
public class DemoApplication {

    private final UserService userService;

	private final UserRepository userRepository;

	@Autowired
    DemoApplication(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository){
		return args -> {
			User u = new User();
			u.setUsername("gugu");
			userService.registerUser(u);
		};
	}

}
