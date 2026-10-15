package com.platzi.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.platzi.pizzeria.persistence.entity.CustomerEntity;

public interface CustomerEntityRepository extends ListCrudRepository<CustomerEntity, String> {

    CustomerEntity findByEmail(String correo);
}
