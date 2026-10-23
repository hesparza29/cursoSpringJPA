package com.platzi.pizzeria.persistence.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.platzi.pizzeria.domain.dto.PizzaPriceUpdateDto;
import com.platzi.pizzeria.persistence.entity.PizzaEntity;


public interface PizzaEntityRepository extends ListCrudRepository<PizzaEntity, Integer> {

    PizzaEntity findByName(String name);

    @Modifying 
    @Query(value = "UPDATE pizza " +
                    "SET price = :price " +
                    "WHERE id_pizza = :id_pizza", nativeQuery = true)
    void updatePrice(@Param("price") double price, @Param("id_pizza") int idPizza);

    @Modifying 
    @Query(value = "UPDATE pizza " +
                    "SET price = :#{#newPizzaPrice.price} " +
                    "WHERE id_pizza = :#{#newPizzaPrice.idPizza}", nativeQuery = true)
    void updatePrice(@Param("newPizzaPrice") PizzaPriceUpdateDto newPizzaPrice);
}
