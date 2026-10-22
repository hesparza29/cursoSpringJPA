package com.platzi.pizzeria.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.platzi.pizzeria.domain.dto.CustomerDto;
import com.platzi.pizzeria.domain.dto.CustomerUpdateDto;
import com.platzi.pizzeria.domain.exception.CustomerAlreadyExistsException;
import com.platzi.pizzeria.domain.exception.EmailAlreadyExistsException;
import com.platzi.pizzeria.domain.exception.NoCustomerExistsException;
import com.platzi.pizzeria.persistence.entity.CustomerEntity;
import com.platzi.pizzeria.persistence.mapper.CustomerMapper;
import com.platzi.pizzeria.persistence.repository.CustomerEntityRepository;

@Service 
public class CustomerServiceImpl implements CustomerService {

    private final CustomerEntityRepository repository;

    private final CustomerMapper mapper;

    public CustomerServiceImpl(CustomerEntityRepository repository,
                                CustomerMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public List<CustomerDto> getAll() {
        List<CustomerEntity> entities = this.repository.findAll();

        if(entities.isEmpty()) {
            throw new NoCustomerExistsException();
        }

        return this.mapper.toDto(entities);
    }

    @Override
    public CustomerDto getById(String id) {
        CustomerEntity entity = this.repository.findById(id).orElse(null);

        if(entity == null) {
            throw new NoCustomerExistsException(id);
        }

        return this.mapper.toDto(entity);
    }

    @Override
    public CustomerDto add(CustomerDto dto) {
        
        if(this.isCustomerExists(dto.idCliente())) {
            throw new CustomerAlreadyExistsException(dto.idCliente());
        }

        if(this.isEmailExists(dto.correo())) {
            throw new EmailAlreadyExistsException(dto.correo());
        }

        CustomerEntity entity = this.mapper.toEntity(dto);
        return this.mapper.toDto(this.repository.save(entity));
    }

    @Override
    public CustomerDto update(String id, CustomerUpdateDto dto) {
        CustomerEntity entity = this.repository.findById(id).orElse(null);

        if(entity == null) {
            throw new NoCustomerExistsException(id);
        }

        this.mapper.updateEntityToDto(dto, entity);
        return this.mapper.toDto(this.repository.save(entity));
    }

    @Override
    public boolean isCustomerExists(String id) {
        CustomerEntity entity = this.repository.findById(id).orElse(null);
        return entity != null ? true : false;
    }
    @Override
    public boolean isEmailExists(String correo) {
        CustomerEntity entity = this.repository.findByEmail(correo);
        return entity != null ? true : false;
    }

    @Override 
    public void delete(String id) {
        
        if(!isCustomerExists(id)) {
            throw new NoCustomerExistsException(id);
        }
        this.repository.deleteById(id);
    }
    @Override
    public CustomerDto getByPhone(String phone) {
        return this.mapper.toDto(this.repository.findByPhone(phone));
    }

}
