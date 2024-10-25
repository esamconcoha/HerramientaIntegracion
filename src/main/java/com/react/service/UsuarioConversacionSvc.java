package com.react.service;

import com.react.models.UsuarioConversacion;

import java.util.List;

public interface UsuarioConversacionSvc {

    List<UsuarioConversacion> findConversacionesByUsuario(String usuario);
}
