package com.platzi.pizzeria.domain.exception;

public class NoCustomerExistsException extends RuntimeException {

    public NoCustomerExistsException(String id) {
        super("No existe registro para un cliente con id " + id);
    }

    public NoCustomerExistsException() {
        super("No existen registros dentro de la tabla customer");
    }
}
