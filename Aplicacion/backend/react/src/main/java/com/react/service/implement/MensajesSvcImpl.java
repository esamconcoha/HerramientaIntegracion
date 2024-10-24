package com.react.service.implement;

import com.react.dtos.OrdenMensajeDto;
import com.react.models.Mensajes;
import com.react.projections.OrdenMensajeProjection;
import com.react.repository.MensajesRepository;
import com.react.service.MensajesSvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensajesSvcImpl implements MensajesSvc {

    @Autowired
    private MensajesRepository repository;

    @Override
    @Transactional
    public Mensajes guardarMensaje(String roomId, Mensajes mensaje) {
        Mensajes nuevoMensaje = new Mensajes();

        try {
            nuevoMensaje.setDescripcionMensaje(mensaje.getDescripcionMensaje());
            nuevoMensaje.setIdUsuarioMensaje(mensaje.getIdUsuarioMensaje());
            nuevoMensaje.setIdConversacion(Long.parseLong(roomId));
            nuevoMensaje.setFechaHoraMensaje(LocalDateTime.now());
            this.repository.save(nuevoMensaje);
            System.out.println("si guarda");
        } catch (Exception e) {
            throw e;
        }
        return nuevoMensaje;
    }

    @Override
    public List<OrdenMensajeProjection> findOrdenMensajes(Integer idConversacion) {
        return this.repository.findOrdenMensajes(idConversacion);
    }


}
