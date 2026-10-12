package com.platzi.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.platzi.pizzeria.persistence.entity.PizzaEntity;

public interface PizzaEntityRepository extends ListCrudRepository<PizzaEntity, Integer> {

}
