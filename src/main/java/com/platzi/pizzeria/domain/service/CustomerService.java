package com.platzi.pizzeria.domain.service;

import java.util.List;

import com.platzi.pizzeria.domain.dto.CustomerDto;
import com.platzi.pizzeria.domain.dto.CustomerUpdateDto;

public interface CustomerService {

    List<CustomerDto> getAll();

    CustomerDto getById(String id);

    CustomerDto add(CustomerDto dto);

    CustomerDto update(String id, CustomerUpdateDto dto);

    boolean isCustomerExists(String id);

    boolean isEmailExists(String correo);

    void delete(String id);

    CustomerDto getByPhone(String phone);
}
