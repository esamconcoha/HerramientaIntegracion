package com.react.service;


import com.react.dtos.UsuarioConversacionDto;
import com.react.models.Conversaciones;
import com.react.models.UsuarioConversacion;

import java.util.List;

public interface ConversacionesSvc {
 public void crearConversacion(List<UsuarioConversacionDto> usuarios);
}
