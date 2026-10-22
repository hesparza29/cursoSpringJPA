package com.platzi.pizzeria.persistence.projection;

import java.time.LocalDateTime;

public interface OrderSummary {

    String getCliente();

    Integer getOrden();

    LocalDateTime getFecha();

    Double getTotal();

    String getPedido();
}
