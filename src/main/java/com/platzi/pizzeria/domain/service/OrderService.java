package com.platzi.pizzeria.domain.service;

import java.util.List;

import com.platzi.pizzeria.domain.dto.OrderDto;
import com.platzi.pizzeria.persistence.projection.OrderSummary;

public interface OrderService {

    List<OrderDto> allOrders();

    List<OrderDto> ordersByCustomer(String idCustomer);

    OrderSummary orderSummary(int idOrder);
}
