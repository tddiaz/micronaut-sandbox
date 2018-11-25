package com.github.tddiaz.domain;

public interface PersonRepository {
    Person save(Person person);
    Person findById(String id);
}
