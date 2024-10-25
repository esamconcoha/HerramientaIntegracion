package com.react.repository;

import com.react.models.UsuarioConversacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioConversacionRepository extends CrudRepository<UsuarioConversacion, Object> {

    @Query(value="SELECT uc.*\n" +
            "FROM react.usuario_conversacion uc\n" +
            "JOIN react.usuario_conversacion uc2\n" +
            "  ON uc.id_conversacion = uc2.id_conversacion\n" +
            "join react.conversaciones c on\n" +
            "uc.id_conversacion =c.id_conversacion \n" +
            "WHERE uc2.usuario = :usuario and c.estado_conversacion",nativeQuery = true)
    List<UsuarioConversacion> findConversacionesByUsuario(@Param("usuario") String usuario);

}
