package com.platzi.pizzeria.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.pizzeria.persistence.entity.OrderEntity;
import com.platzi.pizzeria.persistence.repository.OrderEntityRepository;



@RestController 
@RequestMapping("/orders")
public class OrderController {

    private final OrderEntityRepository repository;

    public OrderController(OrderEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<OrderEntity> getMethodName() {
        return this.repository.findAll();
    }

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<List<OrderEntity>> ordersByCustomer(@PathVariable("idCustomer") String idCustomer) {
        return ResponseEntity.ok(this.repository.findByCustomer(idCustomer));
    }
    
    
}
