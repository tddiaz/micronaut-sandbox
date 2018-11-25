package com.github.tddiaz.application.controller;


import com.github.tddiaz.domain.Person;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
class PersonControllerTest {


    @Inject
    private PersonClient client;

    @Test
    void testGet() {
        Person person = client.get("1");
        assertNotNull(person);
    }

    @Client("/persons")
    interface PersonClient {

        @Get("/{personId}")
        Person get(String personId);
    }

}