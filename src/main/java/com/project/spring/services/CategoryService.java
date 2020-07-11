package com.project.spring.services;

import java.util.List;
import java.util.Optional;

import com.project.spring.entities.Category;
import com.project.spring.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
       Optional<Category> category = categoryRepository.findById(id);
       return category.get();
    }
}