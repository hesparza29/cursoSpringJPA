package com.platzi.pizzeria.web.exception;

import lombok.Builder;

@Builder 
public record Error(
    String type,
    String message
) {

}
