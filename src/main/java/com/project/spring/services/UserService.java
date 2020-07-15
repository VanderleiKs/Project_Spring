package com.project.spring.services;

import java.util.List;
import java.util.Optional;

import com.project.spring.entities.User;
import com.project.spring.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }

    public User insert(User obj){
       return userRepository.save(obj);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User update(Long id, User obj){
        User userUpadate = userRepository.getOne(id);
        updateData(obj, userUpadate);
        return userRepository.save(userUpadate);
    }

    private void updateData(User obj, User userUpadate) {
        userUpadate.setName(obj.getName());
        userUpadate.setEmail(obj.getEmail());
        userUpadate.setPhone(obj.getPhone());
    } 
}