package com.github.tddiaz.application.service;

import com.github.tddiaz.application.controller.PersonDto;
import com.github.tddiaz.domain.Address;
import com.github.tddiaz.domain.Person;
import com.github.tddiaz.domain.PersonRepository;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;

@Singleton
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public Person save(PersonDto personDto) {
        Person person = new Person();
        person.setAge(personDto.getAge());
        person.setName(personDto.getName());
        PersonDto.AddressDto address = personDto.getAddress();
        person.setAddress(Address.valueOf(address.getLine(), address.getCity(), address.getCountry()));

        return personRepository.save(person);
    }

    @Transactional
    public Person update(String personId, PersonDto personDto) {
        Person person = personRepository.findById(personId);
        person.setName(personDto.getName());
        person.setAge(personDto.getAge());
        PersonDto.AddressDto address = personDto.getAddress();
        person.setAddress(Address.valueOf(address.getLine(), address.getCity(), address.getCountry()));

        return personRepository.update(person);
    }

    public Person findById(String id) {
        return personRepository.findById(id);
    }

}
