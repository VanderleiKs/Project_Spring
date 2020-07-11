package com.project.spring.resources;

import java.util.List;

import com.project.spring.entities.Order;
import com.project.spring.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;
    
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        final List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable final Long id) {
        final Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}