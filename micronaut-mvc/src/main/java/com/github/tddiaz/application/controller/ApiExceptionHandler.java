package com.github.tddiaz.application.controller;


import com.github.tddiaz.application.service.exception.PersonNotFoundException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;


@Singleton
@Slf4j
@Requires(classes = {PersonNotFoundException.class, ExceptionHandler.class})
public class ApiExceptionHandler implements ExceptionHandler<PersonNotFoundException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, PersonNotFoundException exception) {
        log.error("{}", exception.getMessage());
        return HttpResponse.badRequest(new ErrorMessage(exception.getMessage()));
    }

    @Getter
    @AllArgsConstructor
    private class ErrorMessage {
        private String message;
    }
}
