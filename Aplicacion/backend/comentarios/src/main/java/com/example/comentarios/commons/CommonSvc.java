package com.example.comentarios.commons;

import java.util.Optional;

public interface CommonSvc <E>{

    public Iterable<E> findAll();

    public Optional<E> findById(Object id);

    public E save(E entity);

    public void deleteById(Object id);

    public Iterable<E> saveAll(Iterable<E> listEntity);
}
