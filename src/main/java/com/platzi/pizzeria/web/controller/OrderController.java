package com.platzi.pizzeria.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.pizzeria.domain.dto.OrderDto;
import com.platzi.pizzeria.domain.service.OrderService;
import com.platzi.pizzeria.persistence.projection.OrderSummary;




@RestController 
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service
    ) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> allOrders() {
        return ResponseEntity.ok(this.service.allOrders());
    }

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<List<OrderDto>> ordersByCustomer(@PathVariable("idCustomer") String idCustomer) {
        return ResponseEntity.ok(this.service.ordersByCustomer(idCustomer));
    }

    @GetMapping("/order-summary/{idOrder}")
    public ResponseEntity<OrderSummary> orderSummary(@PathVariable("idOrder") int idOrder) {
        return ResponseEntity.ok(this.service.orderSummary(idOrder));
    }
    
    
    
}
