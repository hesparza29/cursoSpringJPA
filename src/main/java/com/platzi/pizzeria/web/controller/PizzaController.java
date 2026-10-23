package com.platzi.pizzeria.web.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.pizzeria.domain.dto.PizzaDto;
import com.platzi.pizzeria.domain.dto.PizzaPriceUpdateDto;
import com.platzi.pizzeria.domain.dto.PizzaUpdateDto;
import com.platzi.pizzeria.domain.service.PizzaService;
import com.platzi.pizzeria.persistence.entity.PizzaEntity;

import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/pizzas")
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
    public ResponseEntity<PizzaDto> onePizza(@PathVariable("id") int id) {
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page")
    public ResponseEntity<Page<PizzaEntity>> allPizzasPage(@RequestParam(defaultValue = "1") int page,
                                                            @RequestParam(defaultValue = "3") int elements
        ) {
        return ResponseEntity.ok(this.service.getAllPage(page, elements));
    }

    @GetMapping("/page-sort")
    public ResponseEntity<Page<PizzaEntity>> getMethodName(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int elements,
                                @RequestParam(defaultValue = "price") String sortColumn,
                                @RequestParam(defaultValue = "asc") String sortDirection
        ) {
        return ResponseEntity.ok(this.service.getByAvailable(page, elements, sortColumn, sortDirection));
    }
    
    @PutMapping("/update-price")
    public ResponseEntity<Void> updatePrice(@RequestBody PizzaPriceUpdateDto dto) {
        this.service.updatePrice(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-price-spel")
    public ResponseEntity<Void> updatePriceSpel(@RequestBody PizzaPriceUpdateDto dto) {
        this.service.updatePriceSpel(dto);
        return ResponseEntity.ok().build();
    }
    
}
