package com.example.comentarios.commons;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class CommonSvcImpl <E, R extends CrudRepository<E, Object>> implements CommonSvc<E>{

    protected R repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Object id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Object id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Iterable<E> saveAll(Iterable<E> entities) {
        return repository.saveAll(entities);
    }
}
