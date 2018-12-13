package com.github.tddiaz.domain;

import java.util.List;

public interface DomainRepository<E, ID> {
    <E> E   save(E entity);
    <E> E update(E entity);
    E findById(ID id);
    List<E> findAll();
}
