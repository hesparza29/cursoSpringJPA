package com.platzi.pizzeria.domain.service;

import java.util.List;

import com.platzi.pizzeria.domain.dto.PizzaDto;

public interface PizzaService {

    List<PizzaDto> getAll();

    PizzaDto getById(int id);

    PizzaDto save(PizzaDto dto);

    PizzaDto update(PizzaDto dto);

    boolean isPizzaExists(int id);
}
