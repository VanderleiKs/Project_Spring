package com.project.spring.config;

import java.time.Instant;
import java.util.Arrays;

import com.project.spring.entities.Category;
import com.project.spring.entities.Order;
import com.project.spring.entities.User;
import com.project.spring.entities.enuns.OrderStatus;
import com.project.spring.repositories.CategoryRepository;
import com.project.spring.repositories.OrderRepository;
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

    @Autowired
    private OrderRepository OrderRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");
        
        categoryRepository.saveAll(Arrays.asList(c1, c2));

        User u1 = new User(null, "Leonarda pires", "leonarda@gmail.com", "98723456", "23231");
        User u2 = new User(null, "Ana Paula", "ana@htmail.com", "98675990", "67672");

        Order o1 = new Order(null, Instant.parse("2020-06-29T08:23:23Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.now(), OrderStatus.PAID, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));

        OrderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
    
}