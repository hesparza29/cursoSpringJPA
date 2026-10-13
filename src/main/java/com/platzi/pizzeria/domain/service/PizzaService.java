package com.platzi.pizzeria.domain.service;

import java.util.List;

import com.platzi.pizzeria.domain.dto.PizzaDto;
import com.platzi.pizzeria.domain.dto.PizzaUpdateDto;

public interface PizzaService {

    List<PizzaDto> getAll();

    PizzaDto getById(int id);

    PizzaDto save(PizzaDto dto);

    PizzaDto update(int id, PizzaUpdateDto dto);

    boolean isPizzaExists(int id);

    void delete(int id);
}
