package com.github.tddiaz.application.service.exception;

import lombok.Getter;

@Getter
public class PersonNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5007070706208209485L;

    private String message;

    public PersonNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
