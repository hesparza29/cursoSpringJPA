package com.platzi.pizzeria.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.pizzeria.domain.dto.PizzaDto;
import com.platzi.pizzeria.domain.dto.PizzaUpdateDto;
import com.platzi.pizzeria.domain.service.PizzaService;


@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaService service;

    public PizzaController(PizzaService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<PizzaDto>> allPizza() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaDto> onePizza(@PathVariable int id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @PostMapping
    public ResponseEntity<PizzaDto> save(@RequestBody PizzaDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDto> update(@PathVariable int id, @RequestBody PizzaUpdateDto dto) {
        return ResponseEntity.ok(this.service.update(id, dto));
    }
    
}
