package com.react.service.implement;

import com.react.models.UsuarioConversacion;
import com.react.repository.UsuarioConversacionRepository;
import com.react.service.UsuarioConversacionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioConversacionSvcImpl implements UsuarioConversacionSvc {
    @Autowired
    private UsuarioConversacionRepository repository;

    @Override
   public List<UsuarioConversacion> findConversacionesByUsuario(String usuario){
        List<UsuarioConversacion> conversaciones = repository.findConversacionesByUsuario(usuario);
        return conversaciones;
    }
}
