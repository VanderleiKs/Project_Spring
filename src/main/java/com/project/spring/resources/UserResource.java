package com.project.spring.resources;

import com.project.spring.entities.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Ana Paula", "anapaula@gmail.com", "98989098", "12345");
        return ResponseEntity.ok().body(u);
    }

}