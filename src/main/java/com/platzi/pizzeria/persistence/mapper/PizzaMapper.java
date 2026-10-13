package com.platzi.pizzeria.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.platzi.pizzeria.domain.dto.PizzaDto;
import com.platzi.pizzeria.persistence.entity.PizzaEntity;

@Mapper(componentModel = "spring")
public interface PizzaMapper {

    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "price", target = "precio")
    @Mapping(source = "vegetarian", target = "vegetariana")
    @Mapping(source = "vegan", target = "vegana")
    @Mapping(source = "available", target = "disponible")
    PizzaDto toDto(PizzaEntity entity);
    
    List<PizzaDto> toDto(List<PizzaEntity> entities);

    @InheritInverseConfiguration 
    PizzaEntity toEntity(PizzaDto dto);

}
