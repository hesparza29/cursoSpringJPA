package com.platzi.pizzeria.domain.dto;

public record CustomerUpdateDto(
    String nombre,
    String direccion,
    String telefono
) {

}
