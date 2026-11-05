package com.platzi.pizzeria.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.platzi.pizzeria.domain.dto.OrderDto;
import com.platzi.pizzeria.domain.exception.NoOrderExistsException;
import com.platzi.pizzeria.persistence.entity.OrderEntity;
import com.platzi.pizzeria.persistence.mapper.OrderMapper;
import com.platzi.pizzeria.persistence.projection.OrderSummary;
import com.platzi.pizzeria.persistence.repository.OrderEntityRepository;

@Service 
public class OrderServiceImpl implements OrderService {

    private final OrderEntityRepository repository;

    private final OrderMapper mapper;

    public OrderServiceImpl(OrderEntityRepository repository, 
                            OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<OrderDto> allOrders() {
        List<OrderEntity> entities = this.repository.findAll();
       
        if(entities.isEmpty()) {
            throw new NoOrderExistsException();
        }

        return this.mapper.toDto(entities);
    }

    @Override
    public List<OrderDto> ordersByCustomer(String idCustomer) {
        List<OrderEntity> entities = this.repository.findByCustomer(idCustomer);

        if(entities.isEmpty()) {
            throw new NoOrderExistsException(idCustomer);
        }

        return this.mapper.toDto(entities);
    }

    @Override
    public OrderSummary orderSummary(int idOrder) {
        OrderEntity entity = this.repository.findById(idOrder)
            .orElseThrow(() -> new NoOrderExistsException(idOrder));
        return this.repository.findOrderSummary(entity.getIdOrder());
    }

}
