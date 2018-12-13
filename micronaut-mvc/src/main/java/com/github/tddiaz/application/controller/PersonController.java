package com.github.tddiaz.application.controller;

import com.github.tddiaz.application.service.PersonService;
import com.github.tddiaz.domain.Address;
import com.github.tddiaz.domain.Person;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;
import lombok.extern.slf4j.Slf4j;

import static com.github.tddiaz.application.controller.PersonDto.*;

@Controller("/persons")
@Slf4j
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Get(value = "/{personId}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<Person> get(String personId) {
        log.info("received request get person id: {}", personId);
        return HttpResponse.ok(personService.findById(personId));
    }

    @Post
    @Consumes
    @Produces
    public HttpResponse<PersonDto> create(@Body PersonDto person) {
        Person save = personService.save(person);
        PersonDto personDto = new PersonDto();
        personDto.setAge(save.getAge());
        personDto.setName(save.getName());

        AddressDto addressDto = new AddressDto();
        addressDto.setLine(person.getAddress().getLine());
        addressDto.setCity(person.getAddress().getCity());
        addressDto.setCountry(person.getAddress().getCountry());

        personDto.setAddress(addressDto);

        return HttpResponse.created(personDto);
    }

    @Put(value = "/{personId}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<Person> update(@Body PersonDto person, String personId) {
        return HttpResponse.ok(personService.update(personId, person));
    }
}
