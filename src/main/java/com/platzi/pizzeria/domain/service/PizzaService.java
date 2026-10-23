package com.platzi.pizzeria.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.platzi.pizzeria.domain.dto.PizzaDto;
import com.platzi.pizzeria.domain.dto.PizzaPriceUpdateDto;
import com.platzi.pizzeria.domain.dto.PizzaUpdateDto;
import com.platzi.pizzeria.persistence.entity.PizzaEntity;

public interface PizzaService {

    List<PizzaDto> getAll();

    PizzaDto getById(int id);

    PizzaDto save(PizzaDto dto);

    PizzaDto update(int id, PizzaUpdateDto dto);

    boolean isPizzaExists(int id);

    void delete(int id);

    Page<PizzaEntity> getAllPage(int page, int elemets);

    Page<PizzaEntity> getByAvailable(int page, int elements, String sortColumn, String sortDirection);

    void updatePrice(PizzaPriceUpdateDto dto);

    void updatePriceSpel(PizzaPriceUpdateDto dto);
}
