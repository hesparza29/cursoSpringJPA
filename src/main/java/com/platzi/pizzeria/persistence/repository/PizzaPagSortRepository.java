package com.platzi.pizzeria.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.platzi.pizzeria.persistence.entity.PizzaEntity;

public interface PizzaPagSortRepository extends PagingAndSortingRepository <PizzaEntity, Integer> {

    Page<PizzaEntity> findByAvailableTrue(Pageable pageRequest);
}
