package com.github.tddiaz.application.controller;

import com.github.tddiaz.application.service.PersonService;
import com.github.tddiaz.domain.Person;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.slf4j.Slf4j;

@Controller("/persons")
@Slf4j
public class PersonController implements PersonEndpoints {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Get("/{personId}")
    @Override
    public HttpResponse<Person> get(String personId) {
        log.info("received request get person id: {}", personId);
        return HttpResponse.ok(personService.findById(personId));
    }
}
