package com.platzi.pizzeria.domain.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String correo) {
        super("Ya existe un registro dentro de la tabla cliente con el correo " + correo);
    }
}
