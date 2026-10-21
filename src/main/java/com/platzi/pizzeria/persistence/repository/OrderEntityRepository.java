package com.platzi.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.platzi.pizzeria.persistence.entity.OrderEntity;

public interface OrderEntityRepository extends ListCrudRepository <OrderEntity, Integer> {

}
