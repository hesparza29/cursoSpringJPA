package com.platzi.pizzeria.domain.dto;

/**
 * OrderItemDto
 */
public record OrderItemDto(
    Double cantidad,
    Double precio,
    PizzaDto pizza
) {

}
