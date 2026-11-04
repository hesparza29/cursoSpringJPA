package com.platzi.pizzeria.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.pizzeria.domain.dto.OrderDto;
import com.platzi.pizzeria.persistence.entity.OrderEntity;
import com.platzi.pizzeria.persistence.mapper.OrderMapper;
import com.platzi.pizzeria.persistence.projection.OrderSummary;
import com.platzi.pizzeria.persistence.repository.OrderEntityRepository;




@RestController 
@RequestMapping("/orders")
public class OrderController {

    private final OrderEntityRepository repository;

    private final OrderMapper mapper;

    public OrderController(OrderEntityRepository repository,
                            OrderMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public List<OrderDto> getMethodName() {
        return this.mapper.toDto(this.repository.findAll());
    }

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<List<OrderEntity>> ordersByCustomer(@PathVariable("idCustomer") String idCustomer) {
        return ResponseEntity.ok(this.repository.findByCustomer(idCustomer));
    }

    @GetMapping("/order-summary/{idOrder}")
    public ResponseEntity<OrderSummary> orderSummary(@PathVariable("idOrder") int idOrder) {
        return ResponseEntity.ok(this.repository.findOrderSummary(idOrder));
    }
    
    
    
}
