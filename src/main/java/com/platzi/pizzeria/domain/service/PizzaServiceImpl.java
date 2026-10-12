package com.platzi.pizzeria.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.platzi.pizzeria.domain.dto.PizzaDto;
import com.platzi.pizzeria.persistence.mapper.PizzaMapper;
import com.platzi.pizzeria.persistence.repository.PizzaEntityRepository;

@Service 
public class PizzaServiceImpl implements PizzaService {

    private final PizzaEntityRepository repository;

    private final PizzaMapper mapper;

    public PizzaServiceImpl(PizzaEntityRepository repository,
                                PizzaMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public List<PizzaDto> getAll() {
        return this.mapper.toDto(this.repository.findAll());
    }
    @Override
    public PizzaDto getById(int id) {
        return this.mapper.toDto(this.repository.findById(id).orElse(null));
    }

}
