package com.platzi.pizzeria.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.platzi.pizzeria.domain.dto.PizzaDto;
import com.platzi.pizzeria.domain.exception.NoPizzaExistsException;
import com.platzi.pizzeria.persistence.entity.PizzaEntity;
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
        PizzaEntity entity = this.repository.findById(id).orElse(null);

        if(entity == null){
            throw new NoPizzaExistsException(id);
        }

        return this.mapper.toDto(entity);
    }

    @Override
    public PizzaDto save(PizzaDto dto) {
        PizzaEntity entity = this.mapper.toEntity(dto);
        return this.mapper.toDto(this.repository.save(entity));
    }
    
    @Override
    public PizzaDto update(PizzaDto dto) {
        PizzaEntity entity = this.mapper.toEntity(dto);
        return this.mapper.toDto(this.repository.save(entity));
    }

    @Override
    public boolean isPizzaExists(int id) {
        PizzaEntity entity = this.repository.findById(id).orElse(null);
        return entity != null ? true : false;
    }

}
