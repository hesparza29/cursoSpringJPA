package com.platzi.pizzeria.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.platzi.pizzeria.domain.dto.OrderItemDto;
import com.platzi.pizzeria.persistence.entity.OrderItemEntity;

@Mapper(componentModel = "spring", uses = PizzaMapper.class)
public interface OrderItemMapper {

    @Mapping(source = "quantity", target = "cantidad")
    @Mapping(source = "price", target = "precio")
    OrderItemDto toDto(OrderItemEntity entity);

    List<OrderItemDto> toDto(List<OrderItemEntity> entities);

    @InheritInverseConfiguration 
    OrderItemEntity toEntity(OrderItemDto dto);

}
