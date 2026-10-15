package com.platzi.pizzeria.domain.dto;

public record CustomerDto(
    String idCliente,
    String nombre,
    String direccion,
    String correo,
    String telefono

) {

}
