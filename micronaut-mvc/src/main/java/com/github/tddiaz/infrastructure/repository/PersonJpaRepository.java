package com.github.tddiaz.infrastructure.repository;

import com.github.tddiaz.domain.Person;
import com.github.tddiaz.domain.PersonRepository;
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class PersonJpaRepository extends AbstractJpaRepository<Person, String> implements PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonJpaRepository(@CurrentSession EntityManager entityManager){
        super(entityManager, Person.class);
    }
}
