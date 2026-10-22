package com.platzi.pizzeria.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.platzi.pizzeria.persistence.entity.CustomerEntity;

public interface CustomerEntityRepository extends ListCrudRepository<CustomerEntity, String> {

    CustomerEntity findByEmail(String correo);

    @Query("SELECT c FROM CustomerEntity c WHERE c.phoneNumber = :phone")
    CustomerEntity findByPhone(@Param("phone") String phone);
}
