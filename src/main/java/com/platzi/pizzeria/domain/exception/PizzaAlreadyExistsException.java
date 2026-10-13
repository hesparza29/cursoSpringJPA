package com.platzi.pizzeria.domain.exception;

public class PizzaAlreadyExistsException extends  RuntimeException {

    public PizzaAlreadyExistsException(String name) {
        super("Ya existe un registro para una pizza con nombre " + name);
    }
}
