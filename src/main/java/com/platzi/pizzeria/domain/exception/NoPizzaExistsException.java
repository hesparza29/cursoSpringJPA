package com.platzi.pizzeria.domain.exception;

public class NoPizzaExistsException extends RuntimeException {

    public NoPizzaExistsException(int id) {
        super("No existe registro para una pizza con id "+ id);
    }
}
