package com.github.tddiaz.infrastructure.repository;

import com.github.tddiaz.domain.DomainRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractJpaRepository<E, ID> implements DomainRepository<E, ID> {

    private final EntityManager entityManager;
    private final Class<E> entityClass;

    public AbstractJpaRepository(EntityManager entityManager, Class<E> entityClass) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }

    @Override
    public <E> E save(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public <E> E update(E entity) {
        return entityManager.merge(entity);
    }

    @Override
    public E findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<E> findAll() {

        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        final Root<E> root = criteriaQuery.from(entityClass);

        criteriaQuery.select(root);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
