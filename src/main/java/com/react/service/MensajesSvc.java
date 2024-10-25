package com.react.service;

import com.react.dtos.OrdenMensajeDto;
import com.react.models.Mensajes;
import com.react.projections.OrdenMensajeProjection;

import java.util.List;

public interface MensajesSvc {

    public Mensajes guardarMensaje(String roomId,Mensajes mensaje);

    public List<OrdenMensajeProjection> findOrdenMensajes(Integer idConversacion);
}
