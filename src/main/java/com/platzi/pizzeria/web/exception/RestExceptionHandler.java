package com.platzi.pizzeria.web.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.platzi.pizzeria.domain.exception.NoPizzaExistsException;

@RestControllerAdvice 
public class RestExceptionHandler {

    @ExceptionHandler(NoPizzaExistsException.class)
    public ResponseEntity<Error> handlerException(NoPizzaExistsException ex) {
        Error error = Error.builder()
                            .type("no-pizza-exists")
                            .message(ex.getMessage())
                        .build();
        return ResponseEntity.badRequest().body(error);
    }
}
