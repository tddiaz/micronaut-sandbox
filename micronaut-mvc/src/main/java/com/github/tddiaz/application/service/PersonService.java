package com.github.tddiaz.application.service;

import com.github.tddiaz.application.service.exception.PersonNotFoundException;
import com.github.tddiaz.domain.Address;
import com.github.tddiaz.domain.Person;

import javax.inject.Singleton;

@Singleton
public class PersonService {

    public Person findById(String id) {

        if ("test".equals(id)) {
            throw new PersonNotFoundException("no resource found");
        }

        Person person = new Person();
        person.setName("Manchester Black");
        person.setAge(35);
        person.setAddress(Address.valueOf("Rm 1 Bldg 2 Somewhere St", "Metropolis", "USA"));

        return person;
    }

}
