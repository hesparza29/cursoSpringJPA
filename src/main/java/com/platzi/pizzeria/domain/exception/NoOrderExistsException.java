package com.platzi.pizzeria.domain.exception;

public class NoOrderExistsException extends RuntimeException {

    public NoOrderExistsException() {
        super("No existen registros dentro de la tabla order");
    }

    public NoOrderExistsException(String idCustomer) {
        super("No existen ordenes asociadas al idCliente: " + idCustomer);
    }

    public NoOrderExistsException(int idOrder) {
        super("No existe un resumen de orden para el idOrder: " + idOrder);
    }
}
