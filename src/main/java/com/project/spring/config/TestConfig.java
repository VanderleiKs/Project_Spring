package com.project.spring.config;

import java.time.Instant;
import java.util.Arrays;

import com.project.spring.entities.Category;
import com.project.spring.entities.Order;
import com.project.spring.entities.OrderItem;
import com.project.spring.entities.Payment;
import com.project.spring.entities.Product;
import com.project.spring.entities.User;
import com.project.spring.entities.enuns.OrderStatus;
import com.project.spring.repositories.CategoryRepository;
import com.project.spring.repositories.OrderItemRepository;
import com.project.spring.repositories.OrderRepository;
import com.project.spring.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");

        categoryRepository.saveAll(Arrays.asList(c1, c2));

        User u1 = new User(null, "Leonarda pires", "leonarda@gmail.com", "98723456", "23231");
        User u2 = new User(null, "Ana Paula", "ana@htmail.com", "98675990", "67672");

        Product p1 = new Product(null, "Computador Game", "computador i5", 3100.00, null);
        Product p2 = new Product(null, "O senhor dos Anéis", "Capa dura", 280.00, null);
        Product p3 = new Product(null, "Relogio Digital", "Sensor ao toque", 490.00, null);

        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        Order o1 = new Order(null, Instant.parse("2020-06-29T08:23:23Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.now(), OrderStatus.PAID, u1);

        p1.getCategories().add(c1);
        p2.getCategories().add(c2);
        p3.getCategories().add(c1);

        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        userRepository.saveAll(Arrays.asList(u1, u2));

        OrderRepository.saveAll(Arrays.asList(o1, o2, o3));


        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o2, p3, 3, p3.getPrice());
        OrderItem oi3 = new OrderItem(o3, p2, 1, p2.getPrice());
        OrderItem oi4= new OrderItem(o2, p1, 4, p1.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.now(), o1);
        o1.setPayment(pay1);
        OrderRepository.save(o1);

    }
    
}