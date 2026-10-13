package com.platzi.pizzeria.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.pizzeria.domain.dto.PizzaDto;
import com.platzi.pizzeria.domain.service.PizzaService;


@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaService service;

    public PizzaController(PizzaService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<PizzaDto> allPizza() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public PizzaDto onePizza(@PathVariable int id) {
        return this.service.getById(id);
    }

    @PostMapping
    public PizzaDto save(@RequestBody PizzaDto dto) {
        return this.service.save(dto);
    }

    @PutMapping
    public PizzaDto update(@RequestBody PizzaDto dto) {
        return this.service.save(dto);
    }
    
}
