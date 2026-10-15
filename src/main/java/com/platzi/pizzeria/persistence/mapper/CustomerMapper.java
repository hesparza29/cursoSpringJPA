package com.platzi.pizzeria.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.platzi.pizzeria.domain.dto.CustomerDto;
import com.platzi.pizzeria.domain.dto.CustomerUpdateDto;
import com.platzi.pizzeria.persistence.entity.CustomerEntity;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "idCustomer", target = "idCliente")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "address", target = "direccion")
    @Mapping(source = "email", target = "correo")
    @Mapping(source = "phoneNumber", target = "telefono")
    CustomerDto toDto(CustomerEntity entity);

    List<CustomerDto> toDto(List<CustomerEntity> entities);

    @InheritInverseConfiguration 
    CustomerEntity toEntity(CustomerDto dto);

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "direccion", target = "address")
    @Mapping(source = "telefono", target = "phoneNumber")
    void updateEntityToDto(CustomerUpdateDto dto, @MappingTarget CustomerEntity entity);
}
