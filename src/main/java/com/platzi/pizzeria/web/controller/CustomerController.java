package com.platzi.pizzeria.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.pizzeria.domain.dto.CustomerDto;
import com.platzi.pizzeria.domain.dto.CustomerUpdateDto;
import com.platzi.pizzeria.domain.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController 
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> allCustomer() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> oneCustomer(@PathVariable String id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> add(@RequestBody CustomerDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.add(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable String id, @RequestBody CustomerUpdateDto dto) {
        return ResponseEntity.ok(this.service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerDto> phoneNumber(@PathVariable String phone) {
        return ResponseEntity.ok(this.service.getByPhone(phone));
    }
    
    
}
