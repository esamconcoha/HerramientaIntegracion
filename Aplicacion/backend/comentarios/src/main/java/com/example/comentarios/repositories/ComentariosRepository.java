package com.example.comentarios.repositories;

import com.example.comentarios.models.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentariosRepository extends CrudRepository<Comentarios, Object> {


}
