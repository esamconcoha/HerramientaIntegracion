package com.example.documentos.repositories;

import com.example.documentos.models.Documentos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentosRepository extends CrudRepository<Documentos, Object> {
}
