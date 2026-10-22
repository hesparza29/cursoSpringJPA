package com.platzi.pizzeria.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.platzi.pizzeria.persistence.entity.OrderEntity;
import com.platzi.pizzeria.persistence.projection.OrderSummary;

public interface OrderEntityRepository extends ListCrudRepository <OrderEntity, Integer> {

    @Query(value = "SELECT * FROM pizza_order WHERE id_customer = :idCustomer", nativeQuery=true)
    List<OrderEntity> findByCustomer(@Param("idCustomer") String idCustomer);

    @Query(value = "SELECT c.name AS cliente, po.id_order AS orden , " +
                    "po.date AS fecha, po.total, GROUP_CONCAT(p.name) AS pedido " +
                    "FROM pizza_order po " +
                    "INNER JOIN customer c ON po.id_customer = c.id_customer " +
                    "INNER JOIN order_item oi ON oi.id_order = po.id_order " +
                    "INNER JOIN pizza p ON p.id_pizza = oi.id_pizza " +
                    "WHERE po.id_order  = :idOrder " +
                    "GROUP BY c.name, po.id_order , po.date, po.total", nativeQuery = true)
    OrderSummary findOrderSummary(@Param("idOrder") int idOrder);
    
}
