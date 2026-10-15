package com.platzi.pizzeria.web.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.platzi.pizzeria.domain.exception.CustomerAlreadyExistsException;
import com.platzi.pizzeria.domain.exception.EmailAlreadyExistsException;
import com.platzi.pizzeria.domain.exception.NoCustomerExistsException;
import com.platzi.pizzeria.domain.exception.NoPizzaExistsException;
import com.platzi.pizzeria.domain.exception.PizzaAlreadyExistsException;

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

    @ExceptionHandler(PizzaAlreadyExistsException.class)
    public ResponseEntity<Error> handlerException(PizzaAlreadyExistsException ex) {
        Error error = Error.builder()
                            .type("pizza-already-exists")
                            .message(ex.getMessage())
                        .build();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(NoCustomerExistsException.class)
    public ResponseEntity<Error> handlerException(NoCustomerExistsException ex) {
        Error error = Error.builder()
                            .type("no-customer-exists")
                            .message(ex.getMessage())
                        .build();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<Error> handlerException(CustomerAlreadyExistsException ex){
        return ResponseEntity.badRequest().body(this.buildError("id-customer-exists", ex.getMessage()));
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Error> handlerException(EmailAlreadyExistsException ex) {
        Error error = Error.builder()
                            .type("email-already-exists")
                            .message(ex.getMessage())
                        .build();
        return ResponseEntity.badRequest().body(error);
    }

    private Error buildError(String type, String message) {
        return Error.builder()
                        .type(type)
                        .message(message)
                    .build();
    }
}
