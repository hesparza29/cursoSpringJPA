package com.platzi.pizzeria.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.platzi.pizzeria.persistence.entity.OrderEntity;

public interface OrderEntityRepository extends ListCrudRepository <OrderEntity, Integer> {

    @Query(value = "SELECT * FROM pizza_order WHERE id_customer = :idCustomer", nativeQuery=true)
    List<OrderEntity> findByCustomer(@Param("idCustomer") String idCustomer);

    
}
