package com.platzi.pizzeria.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.platzi.pizzeria.domain.dto.OrderDto;
import com.platzi.pizzeria.persistence.entity.OrderEntity;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class, CustomerMapper.class})
public interface OrderMapper {

    @Mapping(source = "date", target = "fecha")
    @Mapping(source = "method", target = "metodo")
    @Mapping(source = "additionalNotes", target = "nota")
    @Mapping(source = "customer", target = "cliente")
    OrderDto toDto(OrderEntity entity);

    List<OrderDto> toDto(List<OrderEntity> entities);

    @InheritInverseConfiguration 
    OrderEntity toEntity(OrderDto dto);
}
