package com.react.repository;

import com.react.dtos.OrdenMensajeDto;
import com.react.models.Mensajes;
import com.react.projections.OrdenMensajeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajesRepository extends CrudRepository<Mensajes, Object> {

    @Query(value="select m.descripcion_mensaje as descripcionMensaje ,m.id_usuario_mensaje as idUsuarioMensaje,\n" +
            "m.id_conversacion as idConversacion\n" +
            "from react.mensajes m where m.id_conversacion=:idConversacion\n" +
            "order by m.fecha_hora_mensaje asc",nativeQuery = true)
    public List<OrdenMensajeProjection> findOrdenMensajes(@Param("idConversacion") Integer idConversacion);



}
