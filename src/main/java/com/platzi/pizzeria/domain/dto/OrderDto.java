package com.platzi.pizzeria.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(
    LocalDateTime fecha,
    Double total,
    String metodo,
    String nota,
    CustomerDto cliente,
    List<OrderItemDto> item
) {

}
