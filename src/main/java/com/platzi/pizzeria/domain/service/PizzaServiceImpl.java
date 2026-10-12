package com.platzi.pizzeria.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.platzi.pizzeria.domain.dto.PizzaDto;
import com.platzi.pizzeria.persistence.repository.PizzaEntityRepository;

@Service 
public class PizzaServiceImpl implements PizzaService {

    private final PizzaEntityRepository repository;

    public PizzaServiceImpl(PizzaEntityRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<PizzaDto> getAll() {
        return null;
    }

}
