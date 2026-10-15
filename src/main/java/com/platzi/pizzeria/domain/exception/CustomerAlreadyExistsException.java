package com.platzi.pizzeria.domain.exception;

public class CustomerAlreadyExistsException extends RuntimeException {

    public CustomerAlreadyExistsException(String id) {
        super("Ya existe un registro para un cliente con id " + id);
    }
}
