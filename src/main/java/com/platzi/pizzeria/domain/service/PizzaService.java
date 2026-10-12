package com.platzi.pizzeria.domain.service;

import java.util.List;

import com.platzi.pizzeria.domain.dto.PizzaDto;

public interface PizzaService {

    List<PizzaDto> getAll();
}
