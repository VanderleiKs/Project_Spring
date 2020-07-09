package com.project.spring.config;

import java.util.Arrays;

import com.project.spring.entities.User;
import com.project.spring.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Leonarda pires", "leonarda@gmail.com", "98723456", "23231");
        User u2 = new User(null, "Ana Paula", "ana@htmail.com", "98675990", "67672");

        userRepository.saveAll(Arrays.asList(u1, u2));

    }
    
}