package com.platzi.pizzeria.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.platzi.pizzeria.domain.dto.PizzaDto;
import com.platzi.pizzeria.domain.dto.PizzaUpdateDto;
import com.platzi.pizzeria.domain.exception.NoPizzaExistsException;
import com.platzi.pizzeria.domain.exception.PizzaAlreadyExistsException;
import com.platzi.pizzeria.persistence.entity.PizzaEntity;
import com.platzi.pizzeria.persistence.mapper.PizzaMapper;
import com.platzi.pizzeria.persistence.repository.PizzaEntityRepository;
import com.platzi.pizzeria.persistence.repository.PizzaPagSortRepository;

@Service 
public class PizzaServiceImpl implements PizzaService {

    private final PizzaEntityRepository repository;

    private final PizzaMapper mapper;

    private final PizzaPagSortRepository repositoryPage;

    public PizzaServiceImpl(PizzaEntityRepository repository,
                                PizzaMapper mapper,
                                PizzaPagSortRepository repositoryPage
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.repositoryPage = repositoryPage;
    }

    @Override
    public List<PizzaDto> getAll() {
        List<PizzaDto> pizzas = this.mapper.toDto(this.repository.findAll());
        
        if(pizzas.isEmpty()) {
            throw new NoPizzaExistsException();
        }
        
        return pizzas;
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
        PizzaEntity entityValidation = this.repository.findByName(dto.nombre());

        if(entityValidation != null) {
            throw new PizzaAlreadyExistsException(entityValidation.getName());
        }

        PizzaEntity entity = this.mapper.toEntity(dto);
        return this.mapper.toDto(this.repository.save(entity));
    }
    
    @Override
    public PizzaDto update(int id, PizzaUpdateDto dto) {
        PizzaEntity entity = this.repository.findById(id).orElse(null);

        if(entity == null){
            throw new NoPizzaExistsException(id);
        }
        
        this.mapper.updateEntityToDto(dto, entity);
        return this.mapper.toDto(this.repository.save(entity));
    }

    @Override
    public boolean isPizzaExists(int id) {
        PizzaEntity entity = this.repository.findById(id).orElse(null);
        return entity != null ? true : false;
    }

    @Override
    public void delete(int id) {
        PizzaEntity entity = this.repository.findById(id).orElse(null);

        if(entity == null) {
            throw new NoPizzaExistsException(id);
        }

        this.repository.deleteById(id);
    }

    public Page<PizzaEntity> getAllPage(int page, int elements) {
        PageRequest pageRequest = PageRequest.of(page, elements);
        return this.repositoryPage.findAll(pageRequest);
    }

    @Override
    public Page<PizzaEntity> getByAvailable(int page, int elements, String sortColumn, String sortDirection) {
        
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortColumn);
        Pageable pageRequest = PageRequest.of(page, elements, sort);
        return this.repositoryPage.findByAvailableTrue(pageRequest);
    }

}
