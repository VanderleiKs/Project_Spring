package com.project.spring.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.project.spring.entities.User;
import com.project.spring.repositories.UserRepository;
import com.project.spring.services.exceptions.DatabaseException;
import com.project.spring.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
       return userRepository.save(obj);
    }

    public void delete(Long id){
        try{
            userRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException ex){
            throw new ResourceNotFoundException(id);
        }
        catch(DataIntegrityViolationException ex){
            throw new DatabaseException("Error, exist orders for this client");
        }
    }

    public User update(Long id, User obj){
        try{
            User userUpadate = userRepository.getOne(id);
            updateData(obj, userUpadate);
            return userRepository.save(userUpadate);
        }
        catch(EntityNotFoundException ex){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User obj, User userUpadate) {
        if(obj.getName() == null || obj.getEmail() == null){
            throw new DatabaseException("Name and Email not can be empty");
        }
        else{
            userUpadate.setName(obj.getName());
            userUpadate.setEmail(obj.getEmail());
            userUpadate.setPhone(obj.getPhone());
        }
    } 
}