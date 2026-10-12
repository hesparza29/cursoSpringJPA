package com.platzi.pizzeria.domain.dto;

public record PizzaDto(
    String nombre,
    String descripcion,
    Double precio,
    Boolean vegetariana,
    Boolean vegana,
    Boolean disponible
) {

}
